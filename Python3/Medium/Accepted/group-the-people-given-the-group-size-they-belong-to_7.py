class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        groups = {}
        for i, g in enumerate(groupSizes):
            if g not in groups:
                groups[g] = []
            groups[g].append(i)
        res = []
        for g, ids in groups.items():
            for i in range(0, len(ids), g):
                res.append(ids[i:i+g])
        return res