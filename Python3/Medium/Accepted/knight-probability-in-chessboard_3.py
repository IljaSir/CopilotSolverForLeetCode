class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        dp = [[0 for i in range(n)] for j in range(n)]
        dp[row][column] = 1
        for i in range(k):
            dp1 = [[0 for i in range(n)] for j in range(n)]
            for i in range(n):
                for j in range(n):
                    if dp[i][j] != 0:
                        if i > 1 and j > 0:
                            dp1[i-2][j-1] += dp[i][j] / 8
                        if i > 1 and j < n-1:
                            dp1[i-2][j+1] += dp[i][j] / 8
                        if i > 0 and j > 1:
                            dp1[i-1][j-2] += dp[i][j] / 8
                        if i > 0 and j < n-2:
                            dp1[i-1][j+2] += dp[i][j] / 8
                        if i < n-2 and j > 0:
                            dp1[i+2][j-1] += dp[i][j] / 8
                        if i < n-2 and j < n-1:
                            dp1[i+2][j+1] += dp[i][j] / 8
                        if i < n-1 and j > 1:
                            dp1[i+1][j-2] += dp[i][j] / 8
                        if i < n-1 and j < n-2:
                            dp1[i+1][j+2] += dp[i][j] / 8
            dp = dp1
        return sum([sum(i) for i in dp])