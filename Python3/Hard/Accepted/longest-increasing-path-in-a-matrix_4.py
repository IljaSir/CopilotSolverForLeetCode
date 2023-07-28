class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        if not matrix: return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        def dfs(i, j):
            if dp[i][j] != 0: return dp[i][j]
            dp[i][j] = 1
            for r, c in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):
                if 0 <= r < m and 0 <= c < n and matrix[r][c] > matrix[i][j]:
                    dp[i][j] = max(dp[i][j], dfs(r, c) + 1)
            return dp[i][j]
        return max(dfs(i, j) for i in range(m) for j in range(n))