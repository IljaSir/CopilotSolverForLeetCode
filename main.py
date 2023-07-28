from leetcode_config import LeetcodeConfig
import leetcode
import utils
from config import PythonConfig, CPPConfig, RustConfig, JavaConfig
import os
import json
import html
import csv
import requests
import time
from collections import defaultdict

LEETCODE_SESSION = <LEETCODE SESSION> # FILL THIS
CSRF_TOKEN = <CSRF TOKEN> # FILL THIS
config = <CONFIG NAME> # FILL THIS (Example: RustConfig(level=3))

all_problem_names_file = "all_problems.json"

def get_all_problem_names():
    if os.path.isfile(all_problem_names_file): # If file exists, read problems from file
        print(f"Loading all problem names from saved file {all_problem_names_file}")
        data = utils.read_json_from_file(all_problem_names_file)
    else:
        print("Requesting all problem names from LEETCODE")
        request = requests.get('/'.join([LeetcodeConfig.LEET_CODE_URL, 'api/problems/all/']))
        utils.write_to_file(all_problem_names_file, request.text)
        data = json.loads(request.text)
    all_problems = defaultdict(list)
    for p in data.get('stat_status_pairs'):
        all_problems[p.get('difficulty', {}).get('level')].append(p.get('stat', {}).get('question__title_slug'))
    return all_problems

def get_problem_level(all_problems, problem_name):
    for level, problems in all_problems.items():
        if problem_name in problems:
            return level
    return -1

def main():
    processing_dir_name = "Processing"
    os.system(f"mkdir -p {processing_dir_name}")
    
    output_dir_name = "Output"
    os.system(f"mkdir -p {output_dir_name}")
    
    leetcode_config_obj = LeetcodeConfig(LEETCODE_SESSION, CSRF_TOKEN)
    
    print(leetcode_config_obj.get_current_user_status())
        
    all_problems = get_all_problem_names()
    
    total_problems = 0
    for level, problems in all_problems.items():
        print(f"Level {level} has {len(problems)} problems")
        total_problems += len(problems)
        
    print(f"There are {total_problems} problems in total")
    
    problems = all_problems[config.level]
    
    idx = 0
    for j, cur_problem in enumerate(problems[idx:]):
        try:
            response = leetcode_config_obj.get_problem_content(cur_problem)
            #print(response)
            if response.data.question.content is None:
                print(f"Skipping {cur_problem} because we couldn't get the problem content")
                continue
            
            problem_id = response.data.question.question_id
            problem_content = html.unescape(utils.cleanhtml(utils.change_html_sup(response.data.question.content)))
            
            problem_code = {code_snippet.lang: code_snippet.code for code_snippet in response.data.question.code_snippets}
            if config.lang not in problem_code.keys():
                print(f"Skipping {cur_problem} because it doesn't have a solution in {config.lang}")
                continue
            
            text = config.multiline_comment_begin + "\n" + problem_content + config.multiline_comment_end + "\n" + problem_code[config.lang]
            
            file_path = utils.get_current_path() + f"{processing_dir_name}/" + cur_problem + "." + config.lang_short
            utils.write_to_file(file_path, text)
            
            if problem_code[config.lang].count(f'{config.funtion_begins_with}') > 2: # If there are more than 2 functions to implement, skip
                print(f"Skipping {cur_problem} because it has more than 2 functions to implement (NOT SUPPORTED YET)")
                os.system(f"mkdir -p {config.lang}/{config.level_name}/MoreThan2Functions")
                os.system(f"mv {file_path} {config.lang}/{config.level_name}/MoreThan2Functions/")
                continue
            
            solution_file = utils.get_current_path() + config.copilot_solutions_dir + '/' + cur_problem + '.txt'
            
            if not os.path.exists(solution_file):
                os.system(f"osascript script.applescript {file_path} {config.lang} {solution_file}")
            
            solutions = utils.read_from_file(solution_file)
            text = utils.read_from_file(file_path).strip('\n')
            
            if solutions.count('\n') <= 10: # Copilot failed to generate any solutions
                print(f"Copilot failed to generate any solutions for {cur_problem}")
                os.system(f"mkdir -p {config.lang}/{config.level_name}/FailedToSolve")
                os.system(f"mv {file_path} {config.lang}/{config.level_name}/FailedToSolve/")
                continue
            
            # Delete everything before solution begins
            pos = text.find(config.solution_begins_with)
            text = text[pos:]
            
            text_arr = text.split('\n')
            solutions_arr = solutions.split('=======')[1:] #split solutions

            for solution_num, solution in enumerate(solutions_arr):
                output_file_name = f'{output_dir_name}/{cur_problem}_{solution_num}.{config.lang_short}'

                ## Parsing the solution and inserting it into the template
                solution = solution.strip('\n')
                solution_arr = solution.split('\n')
                if 'Suggestion' in solution_arr[0]:
                    solution_arr = solution_arr[1:]
                
                
                idx = 0
                for i, el in enumerate(text_arr):
                    if len(el.strip()) == 0:
                        break
                    if el.strip() == solution_arr[idx].strip():
                        idx += 1
                    elif idx > 0:
                        break

                if config.lang == "Rust" and solution_arr[-1].strip()== '}' and solution_arr[-2].strip()== '}':
                    res_array = text_arr[:i+1] + solution_arr[idx:]
                else:
                    res_array = text_arr[:i+1] + solution_arr[idx:] + text_arr[i+1:]
                
                res = '\n'.join(res_array)
                ##
                
                utils.write_to_file(output_file_name, res)
            
                solution = leetcode.Submission(judge_type="large", lang=config.lang_for_submittion, question_id=problem_id, typed_code=res, test_mode=False)
                
                status = False
                api_response = leetcode_config_obj.api_instance.problems_problem_submit_post(cur_problem, body=solution)
                submission_id = api_response.submission_id
                while not status:
                    time.sleep(5)
                    api_response = leetcode_config_obj.api_instance.submissions_detail_id_check_get(submission_id)
                    if api_response['state'] == "SUCCESS":
                        status = True
                
                fields_to_save = [cur_problem, solution_num, config.level, api_response['question_id'], api_response['status_msg'], api_response['run_success'], api_response['lang'], api_response['status_runtime'], api_response['runtime_percentile'],
                                api_response['memory'], api_response['memory_percentile'], api_response['total_testcases'], api_response['total_correct'], api_response['submission_id']]
                print(f"{cur_problem}: {api_response['status_msg']}")
                results_writer.writerow(fields_to_save)
                status = api_response['status_msg']
                status = "".join(status.split())
                
                os.system(f"mkdir -p {config.lang}/{config.level_name}/{status}")
                os.system(f"mv {output_file_name} {config.lang}/{config.level_name}/{status}/")
                
                time.sleep(5)
                
            os.system(f"rm {file_path}")
                
        except Exception as e:
            print(f"Exception: {e}")
            break
    
if __name__ == "__main__":
    main()