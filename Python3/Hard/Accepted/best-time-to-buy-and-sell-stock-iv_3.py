class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        n = len(prices)
        if k >= n // 2:
            dp_i_0 = 0
            dp_i_1 = -prices[0]
            for i in range(1, n):
                dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
                dp_i_1 = max(dp_i_1, dp_i_0 - prices[i])
            return dp_i_0
        else:
            dp = [[0] * 2 for _ in range(k + 1)]
            for i in range(k + 1):
                dp[i][1] = -prices[0]
            for i in range(1, n):
                for j in range(k, 0, -1):
                    dp[j][0] = max(dp[j][0], dp[j][1] + prices[i])
                    dp[j][1] = max(dp[j][1], dp[j - 1][0] - prices[i])
            return dp[k][0]