class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if grid[i - 1][j - 1] == -1:
                    dp[i][j] = -1
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if dp[i][j] == -1:
                    continue
                if i == 1 and j == 1:
                    dp[i][j] = grid[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
                    if dp[i][j] != -1:
                        dp[i][j] += grid[i - 1][j - 1]
        if dp[n][n] == -1:
            return 0
        for i in range(n - 1, 0, -1):
            for j in range(n - 1, 0, -1):
                if dp[i][j] == -1:
                    continue
                if i == n and j == n:
                    dp[i][j] = grid[i - 1][j - 1]
                else:
                    dp[i][j] = max(dp[i + 1][j], dp[i][j + 1])
                    if dp[i][j] != -1:
                        dp[i][j] += grid[i - 1][j - 1]
        if dp[1][1] == -1:
            return 0
        return dp[1][1]