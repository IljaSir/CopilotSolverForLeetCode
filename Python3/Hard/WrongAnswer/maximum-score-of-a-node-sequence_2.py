class Solution:
    def maximumScore(self, scores: List[int], edges: List[List[int]]) -> int:
        
        n = len(scores)
        dp = [[-1] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = scores[i]
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] = max(dp[i][j], dp[i][j-1], dp[i+1][j])
        for i, j in edges:
            dp[i][j] = dp[j][i] = max(dp[i][j], dp[i+1][j], dp[i][j-1])
        ans = -1
        for i, j in edges:
            ans = max(ans, dp[i][j] + dp[j][i])
        return ans