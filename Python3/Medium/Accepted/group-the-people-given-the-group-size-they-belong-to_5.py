class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        groups = {}
        for i, size in enumerate(groupSizes):
            if size not in groups:
                groups[size] = []
            groups[size].append(i)
        ans = []
        for size, people in groups.items():
            while len(people) > 0:
                ans.append(people[:size])
                people = people[size:]
        return ans