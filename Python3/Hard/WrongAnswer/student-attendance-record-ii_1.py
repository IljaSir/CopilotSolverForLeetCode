class Solution:
    def checkRecord(self, n: int) -> int:
        
        # dp[i][j][k] = number of ways to make i length string with j A's and k L's at the end
        dp = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]
        for i in range(2):
            for j in range(3):
                dp[1][i][j] = 1 if i == 0 or j == 0 else 2
        for i in range(2, n + 1):
            for j in range(2):
                for k in range(3):
                    if j > 0:
                        dp[i][j][0] += dp[i - 1][j - 1][2]
                    dp[i][j][k] += dp[i - 1][j][k - 1] if k > 0 else dp[i - 1][j][2]
        return sum(dp[n][1]) % (10**9 + 7)