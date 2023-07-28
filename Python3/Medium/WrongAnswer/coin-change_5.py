class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [0] + [amount + 1] * amount
        for i in range(1, amount + 1):
            dp[i] = min(dp[i - c] if i - c >= 0 else amount + 1 for c in coins) + 1
        return dp[amount] if dp[amount] != amount + 1 else -1