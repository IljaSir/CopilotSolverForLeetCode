class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        if not prices: return 0
        if k >= len(prices) // 2:
            return sum([max(prices[i + 1] - prices[i], 0) for i in range(len(prices) - 1)])
        dp = [[0] * len(prices) for _ in range(k + 1)]
        for t in range(1, k + 1):
            max_diff = -prices[0]
            for d in range(1, len(prices)):
                dp[t][d] = max(dp[t][d - 1], prices[d] + max_diff)
                max_diff = max(max_diff, dp[t - 1][d] - prices[d])
        return dp[k][-1]