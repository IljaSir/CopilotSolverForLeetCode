class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i, n in enumerate(names):
            if n not in d:
                d[n] = 1
            else:
                while n + '(' + str(d[n]) + ')' in d:
                    d[n] += 1
                d[n + '(' + str(d[n]) + ')'] = 1
                d[n] += 1
                names[i] = n + '(' + str(d[n] - 1) + ')'
        return names