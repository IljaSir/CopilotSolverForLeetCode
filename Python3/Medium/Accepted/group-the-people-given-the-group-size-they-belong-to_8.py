class Solution:
    def groupThePeople(self, groupSizes: List[int]) -> List[List[int]]:
        
        groups = {}
        for i, size in enumerate(groupSizes):
            if size not in groups:
                groups[size] = []
            groups[size].append(i)
        print(groups)
        result = []
        for size, group in groups.items():
            for i in range(0, len(group), size):
                result.append(group[i:i+size])
        return result