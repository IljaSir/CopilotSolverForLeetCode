class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        if not matrix or not matrix[0]:
            return 0
        m, n = len(matrix), len(matrix[0])
        memo = [[0] * n for _ in range(m)]
        def dfs(i, j):
            if memo[i][j] == 0:
                memo[i][j] = 1 + max(
                    dfs(i - 1, j) if i > 0 and matrix[i - 1][j] > matrix[i][j] else 0,
                    dfs(i + 1, j) if i < m - 1 and matrix[i + 1][j] > matrix[i][j] else 0,
                    dfs(i, j - 1) if j > 0 and matrix[i][j - 1] > matrix[i][j] else 0,
                    dfs(i, j + 1) if j < n - 1 and matrix[i][j + 1] > matrix[i][j] else 0)
            return memo[i][j]
        return max(dfs(i, j) for i in range(m) for j in range(n))