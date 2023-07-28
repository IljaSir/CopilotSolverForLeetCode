class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        def is_comment(line):
            for i in range(len(line) - 1):
                if line[i] == '/' and line[i + 1] == '/':
                    return True, i
                elif line[i] == '/' and line[i + 1] == '*':
                    return True, i
            return False, -1
        def is_end_comment(line):
            for i in range(len(line) - 1):
                if line[i] == '*' and line[i + 1] == '/':
                    return True, i
            return False, -1
        def remove_comments(line):
            is_comment_line, i = is_comment(line)
            if is_comment_line:
                line = line[:i]
            return line
        def remove_comment_block(lines):
            i = 0
            while i < len(lines):
                is_end_comment_line, j = is_end_comment(lines[i])
                if is_end_comment_line:
                    lines = lines[:i] + [lines[i][j + 2:]] + lines[i + 1:]
                    break
                i += 1
            return lines
        result = []
        i = 0
        while i < len(source):
            line = source[i]
            is_comment_line, j = is_comment(line)
            if is_comment_line:
                line = line[:j]
                source[i] = line
                is_end_comment_line, j = is_end_comment(line)
                if is_end_comment_line:
                    source[i] = line[j + 2:]
                    i -= 1
                else:
                    source = remove_comment_block(source[i + 1:])
                    i -= 1
            else:
                is_end_comment_line, j = is_end_comment(line)
                if is_end_comment_line:
                    source[i] = line[j + 2:]
                    i -= 1
                else:
                    source = remove_comment_block(source[i + 1:])
                    i -= 1
            i += 1
        for line in source:
            if line:
                result.append(line)
        return result