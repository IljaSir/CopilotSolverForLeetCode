class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [0] + [-6] * amount
        for i in range(1, amount + 1):
            dp[i] = min([dp[i - c] for c in coins if i - c >= 0 and dp[i - c] != -1]) + 1 if min([dp[i - c] for c in coins if i - c >= 0 and dp[i - c] != -1]) != float('inf') else -1
        return dp[-1]