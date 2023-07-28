class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                dp[i][j] = (1, grid[i][j])
                if i > 0 and grid[i - 1][j] < grid[i][j]:
                    dp[i][j] = (dp[i][j][0] + dp[i - 1][j][0], dp[i][j][1])
                if j > 0 and grid[i][j - 1] < grid[i][j]:
                    dp[i][j] = (dp[i][j][0] + dp[i][j - 1][0], dp[i][j][1])
        return dp[m - 1][n - 1][0] % (10 ** 9 + 7)