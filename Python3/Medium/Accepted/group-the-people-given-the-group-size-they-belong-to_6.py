class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        group = {}
        for i, size in enumerate(groupSizes):
            if size not in group:
                group[size] = []
            group[size].append(i)
        res = []
        for size, people in group.items():
            for i in range(0, len(people), size):
                res.append(people[i:i+size])
        return res