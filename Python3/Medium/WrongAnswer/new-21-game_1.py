class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        
        
        if k == 0 or n >= k + maxPts:
            return 1.0
        
        dp = [0.0] * (n + 1)
        dp[0] = 1.0
        W = 0.0
        for i in range(1, n + 1):
            dp[i] = W / maxPts
            if i < k:
                W += dp[i]
            if i - maxPts >= 0:
                W -= dp[i - maxPts]
        
        return sum(dp[k:])