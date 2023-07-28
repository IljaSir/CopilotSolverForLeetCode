class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if len(prices) < 2:
            return 0
        # 1st transaction
        min_price = prices[0]
        # 2nd transaction
        min_price_2 = prices[0]
        # 1st transaction profit
        max_profit = 0
        # 2nd transaction profit
        max_profit_2 = 0
        # 1st transaction profit + 2nd transaction profit
        max_profit_3 = 0
        for i in range(1, len(prices)):
            # 1st transaction
            min_price = min(min_price, prices[i])
            max_profit = max(max_profit, prices[i] - min_price)
            # 2nd transaction
            min_price_2 = min(min_price_2, prices[i] - max_profit)
            max_profit_2 = max(max_profit_2, prices[i] - min_price_2)
            # 1st transaction profit + 2nd transaction profit
            max_profit_3 = max(max_profit_3, max_profit + max_profit_2)
        return max_profit_3