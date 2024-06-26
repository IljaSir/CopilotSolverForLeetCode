class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        
        n = len(piles)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = piles[i]
        for i in range(n - 1):
            dp[i][i + 1] = max(piles[i], piles[i + 1])
        for i in range(n - 2, -1, -1):
            for j in range(i + 2, n):
                dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
        return dp[0][n - 1] > 0