class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        
        dp = grid[0]
        for i in range(1, len(grid)):
            dp = [grid[i][j] + min(dp[:j] + dp[j+1:]) for j in range(len(grid))]
        return min(dp)