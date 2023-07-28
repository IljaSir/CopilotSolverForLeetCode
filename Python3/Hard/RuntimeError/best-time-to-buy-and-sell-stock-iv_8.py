class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j] = max(dp[i][j-1], prices[j] + max(dp[i-1][t] - prices[t])) t: 0..j-1
        # dp[i][j]