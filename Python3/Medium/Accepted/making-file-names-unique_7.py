class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        
        d = {}
        for i in range(len(names)):
            if names[i] not in d:
                d[names[i]] = 1
            else:
                while True:
                    if names[i] + '(' + str(d[names[i]]) + ')' not in d:
                        names[i] = names[i] + '(' + str(d[names[i]]) + ')'
                        d[names[i]] = 1
                        break
                    else:
                        d[names[i]] += 1

        return names