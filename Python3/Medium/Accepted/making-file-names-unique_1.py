class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i, name in enumerate(names):
            if name not in d:
                d[name] = 1
            else:
                while name + '(' + str(d[name]) + ')' in d:
                    d[name] += 1
                name += '(' + str(d[name]) + ')'
                d[name] = 1
            names[i] = name
        return names