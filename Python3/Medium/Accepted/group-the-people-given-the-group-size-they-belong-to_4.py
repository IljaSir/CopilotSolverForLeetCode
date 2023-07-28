class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        d = {}
        for i, size in enumerate(groupSizes):
            if size not in d:
                d[size] = []
            d[size].append(i)
        res = []
        for size, people in d.items():
            for i in range(0, len(people), size):
                res.append(people[i:i+size])
        return res