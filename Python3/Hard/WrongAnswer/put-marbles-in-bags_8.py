class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        # dp[i][j] = min(dp[i][j], dp[i-1][l] + max(weights[l+1:j+1]))
        # dp[i][j] = min(dp[i][j], dp[i][j-1] + max(weights[i:j+1]))
        # dp[i][j] = min(dp[i][j], dp[i-1][l] + max(weights[l+1:j+1]))
        # dp[i][j] = min(dp[i][j], dp[i][j-1] + max(weights[i:j+1]))
        n = len(weights)
        dp = [[float('inf')] * n for _ in range(k)]
        for i in range(k):
            for j in range(i, n):
                if i == 0:
                    dp[i][j] = sum(weights[:j+1]) * (j+1)
                else:
                    for l in range(i-1, j):
                        dp[i][j] = min(dp[i][j], dp[i-1][l] + max(weights[l+1:j+1]) * (j-l))
        return dp[k-1][n-1] - sum(weights)