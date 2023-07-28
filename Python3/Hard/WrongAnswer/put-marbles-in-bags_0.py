class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        n = len(weights)
        dp = [[float('inf')] * (k + 1) for _ in range(n + 1)]
        dp[0][0] = 0
        for i in range(1, n + 1):
            for j in range(1, k + 1):
                for l in range(i):
                    dp[i][j] = min(dp[i][j], max(dp[l][j - 1], sum(weights[l:i])))
        return dp[n][k]