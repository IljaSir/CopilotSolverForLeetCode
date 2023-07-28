class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        ranges.sort()
        for i in range(left, right+1):
            for j in range(len(ranges)):
                if ranges[j][0] <= i <= ranges[j][1]:
                    break
            else:
                return False
        return True