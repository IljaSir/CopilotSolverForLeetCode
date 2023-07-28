class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        n = len(prices)
        res = 0
        for i in range(1, n):
            if prices[i] < prices[i - 1]:
                res += 1
        return res