class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        ranges.sort()
        for i in range(1, len(ranges)):
            if ranges[i][0] <= ranges[i-1][1]:
                ranges[i][0] = ranges[i-1][0]
                ranges[i][1] = max(ranges[i-1][1], ranges[i][1])
        ranges = list(filter(lambda x: x[1] >= left, ranges))
        for i in range(len(ranges)):
            if ranges[i][0] <= left <= ranges[i][1]:
                left = ranges[i][1] + 1
            if left > right:
                return True
        return False