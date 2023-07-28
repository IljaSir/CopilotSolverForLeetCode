class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        # buy[i] = max(sell[i-2]-price, buy[i-1])
        # sell[i] = max(buy[i-1]+price, sell[i-1])
        n = len(prices)
        if n <= 1:
            return 0
        buy = [0] * n
        sell = [0] * n
        buy[0] = -prices[0]
        buy[1] = max(-prices[0], -prices[1])
        sell[1] = max(buy[0] + prices[1], sell[0])
        for i in range(2, n):
            buy[i] = max(sell[i-2]-prices[i], buy[i-1])
            sell[i] = max(buy[i-1]+prices[i], sell[i-1])
        return sell[-1]