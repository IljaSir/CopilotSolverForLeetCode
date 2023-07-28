class Solution:
    def minSteps(self, n: int) -> int:
        
        if n == 1:
            return 0
        dp = [0] * (n+1)
        dp[0] = 0
        dp[1] = 0
        for i in range(2, n+1):
            if i % 2 == 0:
                dp[i] = 2 + dp[i//2]
            else:
                dp[i] = i
        return dp[n]