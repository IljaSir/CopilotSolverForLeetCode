class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        
        
        file_dict = {}
        for path in paths:
            path_list = path.split()
            for i in range(1, len(path_list)):
                file_name, file_content = path_list[i].split('(')
                file_content = file_content[:-1]
                if file_content not in file_dict:
                    file_dict[file_content] = [path_list[0] + '/' + file_name]
                else:
                    file_dict[file_content].append(path_list[0] + '/' + file_name)
        return [file_dict[key] for key in file_dict if len(file_dict[key]) > 1]