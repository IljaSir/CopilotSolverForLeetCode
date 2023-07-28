class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        count = 0
        for i in range(1, len(prices)):
            if prices[i] == prices[i-1] - 1:
                count += 1
        return count + 1