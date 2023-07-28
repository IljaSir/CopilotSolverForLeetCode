class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        d = {}
        for i, size in enumerate(groupSizes):
            if size in d:
                d[size].append(i)
            else:
                d[size] = [i]
        ans = []
        for size, group in d.items():
            for i in range(0, len(group), size):
                ans.append(group[i:i+size])
        return ans