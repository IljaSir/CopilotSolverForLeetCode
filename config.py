import os

class Config:
    
    level_to_level_name_map = {1: 'Easy', 2: 'Medium', 3: 'Hard'}
    
    def __init__(self, level, level_name, lang, lang_for_submittion, lang_short, multiline_comment_begin, multiline_comment_end, solution_begins_with, funtion_begins_with, copilot_solutions_dir) -> None:
        self.level = level
        self.level_name = level_name
        self.lang = lang
        self.lang_for_submittion = lang_for_submittion
        self.lang_short = lang_short
        self.multiline_comment_begin = multiline_comment_begin
        self.multiline_comment_end = multiline_comment_end
        self.funtion_begins_with = funtion_begins_with
        self.solution_begins_with = solution_begins_with
        self.copilot_solutions_dir = copilot_solutions_dir
        os.system(f'mkdir -p {copilot_solutions_dir}')
        
class PythonConfig(Config):
    def __init__(self, level) -> None:
        super().__init__(level=level, level_name=Config.level_to_level_name_map[level], lang="Python3", lang_for_submittion="python3", lang_short="py", multiline_comment_begin='"""', multiline_comment_end='"""', solution_begins_with="class Solution", funtion_begins_with=":\n", copilot_solutions_dir=f'./Copilot_Solutions/Python3/{Config.level_to_level_name_map[level]}/')
        
class CPPConfig(Config):
    def __init__(self, level) -> None:
        super().__init__(level=level, level_name=Config.level_to_level_name_map[level], lang="C++", lang_for_submittion="cpp", lang_short="cpp", multiline_comment_begin='/*', multiline_comment_end='*/', solution_begins_with="class Solution", funtion_begins_with="{", copilot_solutions_dir=f'./Copilot_Solutions/CPP/{Config.level_to_level_name_map[level]}/')
        
class JavaConfig(Config):
    def __init__(self, level) -> None:
        super().__init__(level=level, level_name=Config.level_to_level_name_map[level], lang="Java", lang_for_submittion="java", lang_short="java", multiline_comment_begin='/*', multiline_comment_end='*/', solution_begins_with="class Solution", funtion_begins_with="{", copilot_solutions_dir=f'./Copilot_Solutions/Java/{Config.level_to_level_name_map[level]}/')
        
class RustConfig(Config):
    def __init__(self, level) -> None:
        super().__init__(level=level, level_name=Config.level_to_level_name_map[level], lang="Rust", lang_for_submittion="rust", lang_short="rs", multiline_comment_begin='/*', multiline_comment_end='*/', solution_begins_with="impl Solution", funtion_begins_with="{", copilot_solutions_dir=f'./Copilot_Solutions/Rust/{Config.level_to_level_name_map[level]}/')