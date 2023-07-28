class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        row_max = [max(row) for row in grid]
        col_max = [max(col) for col in zip(*grid)]
        return sum(min(row_max[r], col_max[c]) - val for r, row in enumerate(grid) for c, val in enumerate(row))