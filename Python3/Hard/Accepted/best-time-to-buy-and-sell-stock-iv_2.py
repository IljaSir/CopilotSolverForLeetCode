class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices:
            return 0
        if k >= len(prices) // 2:
            return sum([prices[i] - prices[i-1] for i in range(1, len(prices)) if prices[i] > prices[i-1]])
        dp = [[0] * len(prices) for _ in range(k+1)]
        for i in range(1, k+1):
            tmp_max = -prices[0]
            for j in range(1, len(prices)):
                dp[i][j] = max(dp[i][j-1], prices[j] + tmp_max)
                tmp_max = max(tmp_max, dp[i-1][j-1] - prices[j])
        return dp[-1][-1]