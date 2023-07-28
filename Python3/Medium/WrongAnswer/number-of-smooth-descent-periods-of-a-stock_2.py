class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        n = len(prices)
        res = 0
        for i in range(n):
            j = i + 1
            while j < n and prices[j] == prices[j - 1] - 1:
                j += 1
            res += (j - i) * (j - i - 1) // 2
            i = j - 1
        return res