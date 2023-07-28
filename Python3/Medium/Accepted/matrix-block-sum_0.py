class Solution:
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        
        m = len(mat)
        n = len(mat[0])
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] - dp[i][j] + mat[i][j]
        res = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                r1 = max(0, i-k)
                c1 = max(0, j-k)
                r2 = min(m, i+k+1)
                c2 = min(n, j+k+1)
                res[i][j] = dp[r2][c2] - dp[r1][c2] - dp[r2][c1] + dp[r1][c1]
        return res