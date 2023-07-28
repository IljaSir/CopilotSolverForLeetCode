class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        
        # dp[i][j] is the minimum number of side jumps to get to lane j at position i
        # dp[i][j] = min(dp[i-1][j], dp[i-1][j-1] + 1, dp[i-1][j+1] + 1)
        # dp[0][j] = 0
        # dp[i][0] = dp[i][1] = dp[i][2] = dp[i][3] = inf
        # dp[i][j] = inf if obstacles[i] == j
        # dp[i][j] = dp[i-1][j] if obstacles[i-1] == j
        # dp[i][j] = dp[i-1][j-1] + 1 if obstacles[i-1] == j-1
        # dp[i][j] = dp[i-1][j+1] + 1 if obstacles[i-1] == j+1
        # dp[i][j] = dp[i-1][j] if obstacles[i-1] == j and obstacles[i-2] == j
        # dp[i][j] = dp[i-1][j-1] + 1 if obstacles[i-1] == j-1 and obstacles[i-2] == j-1
        # dp[i][j] = dp[i-1][j+1] + 1 if obstacles[i-1] == j+1 and obstacles[i-2] == j+1
        # dp[i][j] = dp[i-1][j] if obstacles[i-1] == j and obstacles[i-2] == j-1
        # dp[i][j] = dp[i-1][j-1] + 1 if obstacles[i-1] == j-1 and obstacles[i-2] == j
        # dp[i][j] = dp[i-1][j+1] + 1 if obstacles[i-1] == j+1 and obstacles[i-2] == j
        # dp[i][j] = dp[i-1][j] if obstacles[i-1] == j and obstacles[i-2] == j+1
        # dp[i][j] = dp[i-1][j-1] + 1 if obstacles[i-1] == j-1 and obstacles