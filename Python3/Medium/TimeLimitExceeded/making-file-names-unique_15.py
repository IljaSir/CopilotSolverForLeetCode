class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        from collections import defaultdict
        d = defaultdict(int)
        ans = []
        for name in names:
            if d[name] == 0:
                ans.append(name)
                d[name] += 1
            else:
                while True:
                    if d[name] == 0:
                        ans.append(name)
                        d[name] += 1
                        break
                    name = name + '(' + str(d[name]) + ')'
                    d[name] += 1
        return ans