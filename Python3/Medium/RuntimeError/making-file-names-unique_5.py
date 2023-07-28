class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
def getFolderNames(self, names: List[str] -> List[str]:
        res = []
        d = {}
        for name in names:
            if name not in d:
                d[name] = 0
                res.append(name)
           else:
                d[name] =1
                new_name = name + (" + str(d[name] + "
                while new_name in d:
                    d[name] += 1
                    new_name = name + "(" + st (d[nam ]) + ")"
                d[new_name] = 0
                res.append(new_name)
        re      result.append(new_name)
        return result