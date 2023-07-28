class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        code = []
        block = False
        for line in source:
            i = 0
            while i < len(line):
                if not block and i + 1 < len(line) and line[i:i+2] == '//':
                    break
                elif not block and i + 1 < len(line) and line[i:i+2] == '/*':
                    block = True
                    i += 1
                elif block and i + 1 < len(line) and line[i:i+2] == '*/':
                    block = False
                    i += 1
                elif not block:
                    code.append(line[i])
                i += 1
            if not block and code and code[-1] != '