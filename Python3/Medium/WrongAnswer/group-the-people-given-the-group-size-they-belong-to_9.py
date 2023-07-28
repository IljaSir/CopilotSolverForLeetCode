class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        res = []
        for i in range(len(groupSizes)):
            if groupSizes[i] == 1:
                res.append([i])
        for i in range(len(groupSizes)):
            if groupSizes[i] != 1:
                for j in range(len(res)):
                    if len(res[j]) < groupSizes[i]:
                        res[j].append(i)
                        break
                    elif len(res[j]) == groupSizes[i]:
                        res.append([i])
                        break
        return res