class Solution:
    def isCovered(self, ranges: List[List[int]], left: int, right: int) -> bool:
        
        for i in range(left, right+1):
            if not any(start <= i <= end for start, end in ranges):
                return False
        return True