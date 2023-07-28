class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        # DP
        # dp[i][j] = (dp[i-1][j-1] - 1) / 2 + (dp[i-1][j] - 1) / 2
        # dp[i][j] = min(dp[i-1][j-1], dp[i-1][j])
        dp = [[0] * (i+1) for i in range(query_row+1)]
        dp[0][0] = poured
        for i in range(1, query_row+1):
            for j in range(i+1):
                if j == 0:
                    dp[i][j] = max(dp[i-1][j] - 1, 0) / 2
                elif j == i:
                    dp[i][j] = max(dp[i-1][j-1] - 1, 0) / 2
                else:
                    dp[i][j] = (max(dp[i-1][j-1] - 1, 0) + max(dp[i-1][j] - 1, 0)) / 2
        return min(dp[query_row][query_glass], 1)