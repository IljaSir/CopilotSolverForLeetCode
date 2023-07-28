class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        ranges = sorted(ranges, key=lambda x: x[0])
        for i in range(len(ranges)):
            if left <= ranges[i][0] <= right:
                left = ranges[i][1] + 1
                if left > right:
                    return True
        return False