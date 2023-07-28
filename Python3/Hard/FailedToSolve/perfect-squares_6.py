class Solution:
    def numSquares(self, n: int) -> int:
        
        if n == 0:
            return 0
        dp = [float("inf")] * (n + 1)
        dp[0] = 0
        for i in range(n + 1):
            j = 1
            while i + j * j <= n:
                dp[i + j * j] = min(dp[i + j * j], dp[i] + 1)
                j += 1
        return dp[n]