class Solution:
    def maximumScore(self, scores: List[int], edges: List[List[int]]) -> int:
        
        n = len(scores)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = scores[i]
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] = max(scores[j], dp[i][j-1])
        for i in range(n):
            for j in range(i+1, n):
                for k in range(i+1, j):
                    dp[i][j] = max(dp[i][j], dp[i][k-1] + dp[k][j])
        return dp[0][n-1]