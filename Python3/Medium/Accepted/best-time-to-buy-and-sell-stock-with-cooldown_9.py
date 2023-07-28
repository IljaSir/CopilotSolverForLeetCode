class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if len(prices) < 2:
            return 0
        buy = [0] * len(prices)
        sell = [0] * len(prices)
        for i in range(len(prices)):
            if i == 0:
                buy[i] = -prices[i]
                sell[i] = 0
            elif i == 1:
                buy[i] = max(buy[i-1], -prices[i])
                sell[i] = max(sell[i-1], prices[i] + buy[i-1])
            else:
                buy[i] = max(buy[i-1], sell[i-2] - prices[i])
                sell[i] = max(sell[i-1], prices[i] + buy[i-1])
        return sell[-1]