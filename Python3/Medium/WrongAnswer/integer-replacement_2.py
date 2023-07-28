class Solution:
    def integerReplacement(self, n: int) -> int:
        
        dp = [0] * (n + 1)
        for i in range(2, n + 1):
            if i % 2 == 0:
                dp[i] = dp[i // 2] + 1
            else:
                dp[i] = min(dp[i - 1], dp[(i + 1) // 2]) + 2
        return dp[n]