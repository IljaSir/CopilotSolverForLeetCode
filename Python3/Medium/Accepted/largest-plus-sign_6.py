class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        
        grid = [[1 for _ in range(n)] for _ in range(n)]
        for x, y in mines:
            grid[x][y] = 0
        dp = [[[0,0,0,0] for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    if i == 0:
                        dp[i][j][0] = 1
                    else:
                        dp[i][j][0] = dp[i-1][j][0] + 1
                    if j == 0:
                        dp[i][j][1] = 1
                    else:
                        dp[i][j][1] = dp[i][j-1][1] + 1
        for i in range(n-1, -1, -1):
            for j in range(n-1, -1, -1):
                if grid[i][j] == 1:
                    if i == n-1:
                        dp[i][j][2] = 1
                    else:
                        dp[i][j][2] = dp[i+1][j][2] + 1
                    if j == n-1:
                        dp[i][j][3] = 1
                    else:
                        dp[i][j][3] = dp[i][j+1][3] + 1
        ans = 0
        for i in range(n):
            for j in range(n):
                ans = max(ans, min(dp[i][j]))
        return ans