class Solution:
    def countPyramids(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    dp[i + 1][j + 1] = 1 + min(dp[i][j], dp[i][j + 1], dp[i + 1][j])
        return sum(sum(min(dp[i + 1][j], dp[i][j]) for j in range(n)) for i in range(m))