class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        dp = [[[0] * n for _ in range(n)] for _ in range(2)]
        dp[0][0][0] = grid[0][0]
        for t in range(1, 2 * n - 1):
            dp[t % 2] = [[0] * n for _ in range(n)]
            for i in range(max(0, t - n + 1), min(n - 1, t) + 1):
                for j in range(max(0, t - n + 1), min(n - 1, t) + 1):
                    if grid[i][t - i] == -1 or grid[j][t - j] == -1:
                        dp[t % 2][i][j] = -1
                        continue
                    cur = max(dp[(t - 1) % 2][i][j], dp[(t - 1) % 2][i][j - 1], dp[(t - 1) % 2][i - 1][j], dp[(t - 1) % 2][i - 1][j - 1])
                    if cur >= 0:
                        dp[t % 2][i][j] = cur + grid[i][t - i] + (i != j) * grid[j][t - j]
        return max(0, dp[(2 * n - 2) % 2][n - 1][n - 1])