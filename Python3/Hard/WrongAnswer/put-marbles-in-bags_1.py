class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        
        n = len(weights)
        dp = [[0] * (k+1) for _ in range(n+1)]
        for i in range(1, n+1):
            dp[i][1] = dp[i-1][1] + weights[i-1]
        for i in range(1, n+1):
            for j in range(2, k+1):
                for m in range(i):
                    dp[i][j] = max(dp[i][j], dp[m][j-1] + max(dp[i][1] - dp[m][1], dp[m][1] - dp[i][1]))
        return dp[n][k]