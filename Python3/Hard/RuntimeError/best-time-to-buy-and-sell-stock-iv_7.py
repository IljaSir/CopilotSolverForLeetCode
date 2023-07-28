class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        n = len(prices)
        if k > n/2:
            return self.maxProfit2(prices)
        dp = [[0]*n for _ in range(k+1)]
        for i in range(1, k+1):
            maxdiff = -prices[0]
            for j in range(1, n):
                dp[i][j] = max(dp[i][j-1], prices[j]+maxdiff)
                maxdiff = max(maxdiff, dp[i-1][j-1]-prices[j])
        return dp[k][n-1]