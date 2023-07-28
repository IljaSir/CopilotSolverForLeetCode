class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        res = []
        d = {}
        for name in names:
            if name not in d:
                res.append(name)
                d[name] = 1
            else:
                while name + '(' + str(d[name]) + ')' in d:
                    d[name] += 1
                res.append(name + '(' + str(d[name]) + ')')
                d[name + '(' + str(d[name]) + ')'] = 1
        return res