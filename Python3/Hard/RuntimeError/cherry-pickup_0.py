class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        dp = [[[0] * n for _ in range(n)] for _ in range(n)]
        dp[0][0][0] = grid[0][0]
        for t in range(1, 2 * n - 1):
            for i in range(n):
                for j in range(n):
                    if grid[i][t-i] == -1 or grid[j][t-j] == -1:
                        dp[i][j][t] = -1
                        continue
                    if i > 0:
                        dp[i][j][t] = max(dp[i][j][t], dp[i-1][j][t-1])
                    if j > 0:
                        dp[i][j][t] = max(dp[i][j][t], dp[i][j-1][t-1])
                    if i > 0 and j > 0:
                        dp[i][j][t] = max(dp[i][j][t], dp[i-1][j-1][t-1])
                    if dp[i][j][t] >= 0:
                        dp[i][j][t] += grid[i][t-i] + (i != j) * grid[j][t-j]
        return max(0, dp[n-1][n-1][2*n-2])