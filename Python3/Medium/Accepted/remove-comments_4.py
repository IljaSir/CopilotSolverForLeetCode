class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        result = []
        block = False
        for line in source:
            if not block:
                newline = ''
            i = 0
            while i < len(line):
                if not block and line[i:i+2] == '/*':
                    block = True
                    i += 1
                elif block and line[i:i+2] == '*/':
                    block = False
                    i += 1
                elif not block and line[i:i+2] == '//':
                    break
                elif not block:
                    newline += line[i]
                i += 1
            if newline and not block:
                result.append(newline)
        return result