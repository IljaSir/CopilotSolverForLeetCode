class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        
        n = len(stones)
        dp = [0] * n
        dp[0] = stones[0]
        for i in range(1, n):
            dp[i] = dp[i - 1] + stones[i]
        for i in range(n - 2, 0, -1):
            dp[i] = max(dp[i], dp[i + 1])
        return dp[1]