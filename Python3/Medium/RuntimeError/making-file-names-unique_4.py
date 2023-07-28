class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        seen = {}
        result = []
        for name in names:
            if name not in seen:
                seen[name] = 0
                result.append(name)
            else:
                seen[name] += 1
                new_name = name + f"({seen[name]})"
                while new_name in seen:
                    seen[name] += 1
                    new_name = name + f"({seen[name]})"
                seen[new_name] = 0) + ")")
        return res