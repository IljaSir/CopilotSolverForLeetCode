class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        rmax = [max(row) for row in grid]
        cmax = [max(col) for col in zip(*grid)]
        return sum(min(rmax[r], cmax[c]) - val for r, row in enumerate(grid) for c, val in enumerate(row))