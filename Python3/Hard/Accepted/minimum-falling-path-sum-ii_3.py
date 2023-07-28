class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        
        # dp[i][j] = min(dp[i-1][k]) + grid[i][j], k != j
        n = len(grid)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if i == 0:
                    dp[i][j] = grid[i][j]
                else:
                    dp[i][j] = min(dp[i-1][k] for k in range(n) if k != j) + grid[i][j]
        return min(dp[n-1])