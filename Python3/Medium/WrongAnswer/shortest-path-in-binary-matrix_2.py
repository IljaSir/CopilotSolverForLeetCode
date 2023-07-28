class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        
        if grid[0][0] == 1 or grid[-1][-1] == 1:
            return -1
        
        n = len(grid)
        dp = [[0] * n for _ in range(n)]
        dp[0][0] = 1
        
        for i in range(n):
            for j in range(n):
                if (i == 0 and j == 0) or grid[i][j] == 1:
                    continue
                if i > 0:
                    dp[i][j] = min(dp[i][j], dp[i-1][j] + 1)
                if j > 0:
                    dp[i][j] = min(dp[i][j], dp[i][j-1] + 1)
                if i > 0 and j > 0:
                    dp[i][j] = min(dp[i][j], dp[i-1][j-1] + 1)
                if i > 0 and j < n - 1:
                    dp[i][j] = min(dp[i][j], dp[i-1][j+1] + 1)
        
        return dp[-1][-1] if dp[-1][-1] > 0 else -1