class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        periods = 0
        for i in range(1, len(prices)):
            if prices[i] == prices[i-1] - 1:
                periods += 1
            elif prices[i] < prices[i-1] - 1:
                periods += 2
        return periods + 1