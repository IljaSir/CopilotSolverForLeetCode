class Solution:
    def maxJump(self, stones: List[int]) -> int:
        
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        N = len(stones)
        dp = [float('inf')] * N
        dp[0] = 0
        for i in range(N):
            for k in range(i+1, N):
                if stones[k] - stones[i] > dp[i] + 1:
                    break
                dp[k] = min(dp[k], max(dp[i], stones[k] - stones[i]))
        return dp[-1]