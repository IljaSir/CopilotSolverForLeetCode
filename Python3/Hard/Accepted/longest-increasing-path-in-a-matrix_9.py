class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        if len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        def dfs(i, j):
            if dp[i][j] > 0:
                return dp[i][j]
            dp[i][j] = 1
            for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                if 0 <= x < m and 0 <= y < n and matrix[x][y] > matrix[i][j]:
                    dp[i][j] = max(dp[i][j], dfs(x, y)+1)
            return dp[i][j]
        res = 0
        for i in range(m):
            for j in range(n):
                res = max(res, dfs(i, j))
        return res