class Solution:
    def minSteps(self, n: int) -> int:
        
        # dp[i] = min(dp[j]+i//j) for j in range(1,i) if i%j==0
        dp = [0]*(n+1)
        for i in range(2,n+1):
            dp[i] = min(dp[j]+i//j for j in range(1,i) if i%j==0)
        return dp[n]