class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        top = [max(row) for row in grid]
        left = [max(col) for col in zip(*grid)]
        return sum(min(top[r], left[c]) - val for r, row in enumerate(grid) for c, val in enumerate(row))