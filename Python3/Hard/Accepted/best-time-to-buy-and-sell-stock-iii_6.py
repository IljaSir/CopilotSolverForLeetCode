class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if len(prices) < 2:
            return 0
        dp = [[0, -prices[0]] for _ in range(3)]
        for price in prices:
            for i in range(1, 3):
                dp[i][1] = max(dp[i][1], dp[i-1][0] - price)
                dp[i][0] = max(dp[i][0], dp[i][1] + price)
        return dp[2][0]