class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        multiline_comment = False
        multiline_comment_begin = '/*'
        multiline_comment_end = '*/'
        line_comment = '//'
        result = []
        for line in source:
            # print(line)
            if not multiline_comment:
                new_line = ""
            i = 0
            while i < len(line):
                # print(i)
                if not multiline_comment and line[i:].startswith(multiline_comment_begin):
                    multiline_comment = True
                    i += len(multiline_comment_begin)
                elif multiline_comment and line[i:].startswith(multiline_comment_end):
                    multiline_comment = False
                    i += len(multiline_comment_end)
                elif not multiline_comment and line[i:].startswith(line_comment):
                    break
                elif not multiline_comment:
                    new_line += line[i]
                    i += 1
                else:
                    i += 1
            if new_line != "" and not multiline_comment:
                result.append(new_line)
        return result