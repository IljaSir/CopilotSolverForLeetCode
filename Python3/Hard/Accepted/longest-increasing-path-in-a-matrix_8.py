class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        m, n = len(matrix), len(matrix[0])
        dp = [[0] * n for _ in range(m)]
        
        def dfs(i, j):
            if dp[i][j] != 0: return dp[i][j]
            for di, dj in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                if 0 <= i + di < m and 0 <= j + dj < n and matrix[i + di][j + dj] > matrix[i][j]:
                    dp[i][j] = max(dp[i][j], dfs(i + di, j + dj))
            dp[i][j] += 1
            return dp[i][j]
        
        return max(dfs(i, j) for i in range(m) for j in range(n))