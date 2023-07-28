class Solution:
    def countPyramids(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        for j in range(n):
            dp[0][j] = grid[0][j]
        for i in range(1, m):
            for j in range(n):
                if grid[i][j]:
                    dp[i][j] = dp[i - 1][j] + 1
        ans = 0
        for i in range(m):
            for j in range(n):
                if not grid[i][j]:
                    continue
                k = 0
                while i + k < m and j - k >= 0 and j + k < n and grid[i + k][j - k] and grid[i + k][j + k]:
                    if dp[i + k][j - k] >= k + 1 and dp[i + k][j + k] >= k + 1:
                        ans += 1
                    k += 1
        return ans