class Solution:
    def countGoodNumbers(self, n: int) -> int:
        
        # dp[i] = dp[i-1]*5 + dp[i-2]*4
        # dp[0] = 5, dp[1] = 20
        if n == 0:
            return 0
        if n == 1:
            return 5
        if n == 2:
            return 20
        dp = [0]*(n+1)
        dp[0] = 5
        dp[1] = 20
        for i in range(2, n+1):
            dp[i] = dp[i-1]*5 + dp[i-2]*4
        return dp[n] % (10**9+7)