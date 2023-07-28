class Solution:
    def minSteps(self, n: int) -> int:
        
        if n < 2:
            return 0
        dp = [0] * (n+1)
        for i in range(2, n+1):
            for j in range(1, i):
                if i % j == 0:
                    dp[i] = dp[j] + i // j
                    break
        return dp[n]