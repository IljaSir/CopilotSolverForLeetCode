class Solution:
    def countHousePlacements(self, n: int) -> int:
        
        MOD = 10**9 + 7
        # dp[i] = number of ways to place houses on i plots
        # dp[i] = dp[i - 1] * 3 + dp[i - 2] * 2
        dp = [1, 4]
        for i in range(2, n + 1):
            dp.append((dp[i - 1] * 3 + dp[i - 2] * 2) % MOD)
        return dp[n]