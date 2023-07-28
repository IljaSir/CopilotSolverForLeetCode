class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        ranges = sorted(ranges, key=lambda x: x[0])
        for i in range(len(ranges)-1):
            if ranges[i][1] >= ranges[i+1][0]:
                ranges[i+1][0] = ranges[i][0]
                ranges[i+1][1] = max(ranges[i][1], ranges[i+1][1])
                ranges[i] = [0, 0]
        ranges = [r for r in ranges if r[0] != 0]
        for r in ranges:
            if r[0] <= left and r[1] >= right:
                return True
        return False