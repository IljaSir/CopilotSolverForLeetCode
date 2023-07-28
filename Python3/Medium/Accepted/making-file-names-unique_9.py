class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i, name in enumerate(names):
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
        return names