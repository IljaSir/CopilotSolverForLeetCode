class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # buy[i] = max(buy[i-1], sell[i-2] - prices[i])
        # sell[i] = max(sell[i-1], buy[i-1] + prices[i])
        if not prices:
            return 0
        buy = [0] * len(prices)
        sell = [0] * len(prices)
        buy[0] = -prices[0]
        sell[0] = 0
        for i in range(1, len(prices)):
            if i == 1:
                buy[i] = max(buy[i-1], -prices[i])
            else:
                buy[i] = max(buy[i-1], sell[i-2] - prices[i])
            sell[i] = max(sell[i-1], buy[i-1] + prices[i])
        return sell[-1]