class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        
        n = len(prices)
        if n == 1:
            return 1
        ans = 1
        for i in range(1, n):
            if prices[i] == prices[i-1] - 1:
                ans += 1
        return ans