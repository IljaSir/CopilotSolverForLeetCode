class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        res = 0
        for i in range(m):
            for j in range(n):
                res = max(res, self.dfs(matrix, i, j, dp))
        return res