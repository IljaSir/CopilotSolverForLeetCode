class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        length = len(prices)
        if length == 1:
            return 1
        result = 0
        for i in range(1, length):
            if prices[i] == prices[i - 1] - 1:
                result += 1
            elif prices[i] < prices[i - 1] - 1:
                result += 2
        return result