class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        
        
        rides.sort(key=lambda x: x[1])
        dp = [0 for i in range(n+1)]
        for i in range(len(rides)):
            start, end, tip = rides[i]
            dp[end] = max(dp[end], dp[start] + end - start + tip)
            if i > 0:
                dp[end] = max(dp[end], dp[end-1])
        return dp[-1]