class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        if k > len(prices) // 2:
            return self.quickSolve(prices)
        dp = [[0] * len(prices) for _ in range(k + 1)]
        for i in range(1, k + 1):
            tmpMax = -prices[0]
            for j in range(1, len(prices)):
                dp[i][j] = max(dp[i][j - 1], prices[j] + tmpMax)
                tmpMax = max(tmpMax, dp[i - 1][j - 1] - prices[j])
        return dp[-1][-1]