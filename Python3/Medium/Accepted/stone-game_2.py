class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        
        # # Approach 1: Dynamic Programming
        # # Time  complexity: O(N^2)
        # # Space complexity: O(N^2)
        # # dp[i][j] = the largest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
        # # dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
        # N = len(piles)
        # dp = [[0] * N for _ in range(N)]
        # for i in range(N):
        #     dp[i][i] = piles[i]
        # for i in range(N - 2, -1, -1):
        #     for j in range(i + 1, N):
        #         dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
        # return dp[0][N - 1] > 0
        
        # Approach 2: Math
        # Time  complexity: O(1)
        # Space complexity: O(1)
        return True