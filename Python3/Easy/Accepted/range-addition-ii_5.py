class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        
        if len(ops) == 0:
            return m * n
        min_x = min([x[0] for x in ops])
        min_y = min([x[1] for x in ops])
        return min_x * min_y