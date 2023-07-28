class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        
        # Dynamic programming
        # dp[i][j] is the max score difference between player 1 and player 2 when the piles are piles[i], piles[i+1], ..., piles[j].
        # dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
        # dp[i][i] = piles[i]
        # dp[i][i+1] = max(piles[i] - piles[i+1], piles[i+1] - piles[i])
        # dp[i][i+2] = max(piles[i] - piles[i+1] - piles[i+2], piles[i+2] - piles[i+1] - piles[i])
        # dp[i][i+3] = max(piles[i] - piles[i+1] - piles[i+2] - piles[i+3], piles[i+3] - piles[i+2] - piles[i+1] - piles[i])
        # dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
        # dp[i][j] = max(piles[i] - piles[i+1] - dp[i+2][j], piles[i] - piles[j] - dp[i+1][j-1], piles[j] - piles[i] - dp[i][j-2], piles[j] - piles[j-1] - dp[i][j-3])
        # dp[i][j] = max(piles[i] - piles[i+1] - dp[i+2][j], piles[i] - piles[j] - dp[i+1][j-1], piles[j] - piles[i] - dp[i][j-2], piles[j] - piles[j-1] - dp[i][j-3])
        # dp[i][j] = max(piles[i] - piles[i+1] - dp[i+2][j], piles[i] - piles[j] - dp[i+1][j-1], piles[j] - piles[i] - dp[i][j-2], piles[j] - piles[j-1] - dp[i][j-3])
        # dp[i][j] = max(piles[i] - piles[i+1] - dp[i+2][j], piles[i