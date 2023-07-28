class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        return sum(1 for i in range(1, len(prices)) if prices[i] == prices[i - 1] + 1)