class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        n = len(prices)
        if n <= 1:
            return 0
        dp = [[0]*n for _ in range(3)]
        for k in range(1, 3):
            for i in range(1, n):
                dp[k][i] = max(dp[k][i-1], prices[i] - prices[0])
                for j in range(1, i):
                    dp[k][i] = max(dp[k][i], dp[k-1][j-1] + prices[i] - prices[j])
        return dp[2][n-1]