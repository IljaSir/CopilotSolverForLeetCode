class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i, name in enumerate(names):
            if name in d:
                j = d[name]
                while name+'('+str(j)+')' in d:
                    j += 1
                d[name+'('+str(j)+')'] = 1
                d[name] = j+1
                names[i] = name+'('+str(j)+')'
            else:
                d[name] = 1
        return names