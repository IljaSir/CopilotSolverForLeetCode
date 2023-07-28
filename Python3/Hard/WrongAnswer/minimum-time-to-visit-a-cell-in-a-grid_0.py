class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        dp = [[float('inf') for _ in range(n)] for _ in range(m)]
        dp[0][0] = 0
        for i in range(m):
            for j in range(n):
                for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    if 0 <= i + di < m and 0 <= j + dj < n:
                        dp[i + di][j + dj] = min(dp[i + di][j + dj], max(dp[i][j], grid[i + di][j + dj]))
        return dp[-1][-1]