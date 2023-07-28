class Solution:
    def kInversePairs(self, n: int, k: int) -> int:
        
        # dp[i][j]: the number of arrays of length i with exactly j inverse pairs
        dp = [[0] * (k+1) for _ in range(n+1)]
        dp[1][0] = 1
        MOD = 10**9 + 7
        for i in range(2, n+1):
            dp[i][0] = 1
            for j in range(1, k+1):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                if j >= i:
                    dp[i][j] -= dp[i-1][j-i]
                dp[i][j] %= MOD
        return dp[n][k]