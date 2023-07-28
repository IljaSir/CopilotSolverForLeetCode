class Solution:
    def numTilings(self, n: int) -> int:
        
        # dp[i] = dp[i-1] + dp[i-2] + 2 * dp[i-3] + 2 * dp[i-4] + ... + 2 * dp[0]
        # dp[i] = 2 * dp[i-1] + dp[i-3]
        # dp[0] = 1
        # dp[1] = 1
        # dp[2] = 2
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 2
        a, b, c = 1, 1, 2
        for i in range(3, n+1):
            a, b, c = b, c, (2*c + a) % (10**9+7)
        return c