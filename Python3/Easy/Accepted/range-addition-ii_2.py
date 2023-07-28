class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        
        min_m = m
        min_n = n
        for op in ops:
            if op[0] < min_m:
                min_m = op[0]
            if op[1] < min_n:
                min_n = op[1]
        return min_m*min_n