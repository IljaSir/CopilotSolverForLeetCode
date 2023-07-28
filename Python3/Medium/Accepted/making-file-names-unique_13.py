class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        res = []
        for name in names:
            if name not in d:
                d[name] = 1
                res.append(name)
            else:
                k = d[name]
                while name + "(" + str(k) + ")" in d:
                    k += 1
                d[name + "(" + str(k) + ")"] = 1
                d[name] = k + 1
                res.append(name + "(" + str(k) + ")")
        return res