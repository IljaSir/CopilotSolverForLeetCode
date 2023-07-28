class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        
        dp = [[[0] * maxMove for _ in range(n)] for _ in range(m)]
        for i in range(maxMove):
            for j in range(m):
                for k in range(n):
                    if j == 0:
                        dp[j][k][i] += 1
                    if j == m - 1:
                        dp[j][k][i] += 1
                    if k == 0:
                        dp[j][k][i] += 1
                    if k == n - 1:
                        dp[j][k][i] += 1
                    if i > 0:
                        if j > 0:
                            dp[j][k][i] += dp[j - 1][k][i - 1]
                        if j < m - 1:
                            dp[j][k][i] += dp[j + 1][k][i - 1]
                        if k > 0:
                            dp[j][k][i] += dp[j][k - 1][i - 1]
                        if k < n - 1:
                            dp[j][k][i] += dp[j][k + 1][i - 1]
        return dp[startRow][startColumn][maxMove - 1] % (10**9 + 7)