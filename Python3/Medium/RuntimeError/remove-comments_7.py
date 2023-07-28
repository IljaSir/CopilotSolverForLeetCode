class Solution:
    def removeComments(self, source: List[str]) -> List[str]:
        
        multi = False
        ans = []
        for line in source:
            i = 0
            while i < len(line):
                if multi:
                    if line[i] == '*' and i + 1 < len(line) and line[i + 1] == '/':
                        multi = False
                        i += 1
                else:
                    if line[i] == '/' and i + 1 < len(line) and line[i + 1] == '/':
                        break
                    elif line[i] == '/' and i + 1 < len(line) and line[i + 1] == '*':
                        multi = True
                        i += 1
                    else:
                        ans.append(line[i])
                i += 1
            if not multi and ans and ans[-1] != '