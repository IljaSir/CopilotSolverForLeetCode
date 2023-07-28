class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        row_max = list(map(max, grid))
        col_max = list(map(max, zip(*grid)))
        return sum(min(row_max[r], col_max[c]) - val
                   for r, row in enumerate(grid)
                   for c, val in enumerate(row))