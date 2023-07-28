class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        d = {}
        for i in range(len(groupSizes)):
            if groupSizes[i] not in d:
                d[groupSizes[i]] = [i]
            else:
                d[groupSizes[i]].append(i)
        res = []
        for k, v in d.items():
            for i in range(0, len(v), k):
                res.append(v[i:i+k])
        return res