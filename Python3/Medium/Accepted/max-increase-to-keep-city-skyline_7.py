class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        max_top = [0] * n
        max_left = [0] * n
        for i in range(n):
            for j in range(n):
                max_top[i] = max(max_top[i], grid[i][j])
                max_left[j] = max(max_left[j], grid[i][j])
        res = 0
        for i in range(n):
            for j in range(n):
                res += min(max_top[i], max_left[j]) - grid[i][j]
        return res