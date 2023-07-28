class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        res = []
        d = {}
        for i, size in enumerate(groupSizes):
            if size not in d:
                d[size] = [i]
            else:
                d[size].append(i)
            if len(d[size]) == size:
                res.append(d[size])
                d[size] = []
        return res