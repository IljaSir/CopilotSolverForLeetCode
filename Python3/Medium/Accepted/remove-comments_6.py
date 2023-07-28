class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        is_block = False
        res = []
        for line in source:
            if not is_block:
                new_line = []
            i = 0
            while i < len(line):
                if not is_block and i + 1 < len(line) and line[i:i + 2] == '//':
                    break
                elif not is_block and i + 1 < len(line) and line[i:i + 2] == '/*':
                    is_block = True
                    i += 1
                elif is_block and i + 1 < len(line) and line[i:i + 2] == '*/':
                    is_block = False
                    i += 1
                elif not is_block:
                    new_line.append(line[i])
                i += 1
            if new_line and not is_block:
                res.append(''.join(new_line))
        return res