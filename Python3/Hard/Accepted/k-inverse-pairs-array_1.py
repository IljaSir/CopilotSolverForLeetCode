class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 1
        for i in range(1, n + 1):
            for j in range(k + 1):
                dp[i][j] = dp[i - 1][j]
                if j >= i:
                    dp[i][j] -= dp[i - 1][j - i]
                if j > 0:
                    dp[i][j] += dp[i][j - 1]
                dp[i][j] %= 10 ** 9 + 7
        return dp[-1][-1]