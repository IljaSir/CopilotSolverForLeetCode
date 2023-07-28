class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        l, r = len(grid), len(grid[0])
        row_max, col_max = [0] * l, [0] * r
        for i in range(l):
            for j in range(r):
                row_max[i] = max(row_max[i], grid[i][j])
                col_max[j] = max(col_max[j], grid[i][j])
        ans = 0
        for i in range(l):
            for j in range(r):
                ans += min(row_max[i], col_max[j]) - grid[i][j]
        return ans