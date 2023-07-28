class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i, name i enumerate(names):
            if name in d:
                d[name] += 1
                new_name = name + f"({d[name]})"
                while new_name in d:
                    d[name] += 1
                    new_name = name + f"({d[name]})"
                d[new_name] = 0
                names[i] = new_name
            else:
                d[name] = 0
        return name
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