class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        
        grid = [[1]*n for _ in range(n)]
        for x, y in mines:
            grid[x][y] = 0
        dp = [[[0]*n for _ in range(n)] for _ in range(4)]
        for i in range(n):
            for j in range(n):
                dp[0][i][j] = 1 if grid[i][j] == 1 and (i == 0 or dp[0][i-1][j] == 0) else 0
                dp[1][i][j] = 1 if grid[i][j] == 1 and (j == n-1 or dp[1][i][j+1] == 0) else 0
                dp[2][i][j] = 1 if grid[i][j] == 1 and (i == n-1 or dp[2][i+1][j] == 0) else 0
                dp[3][i][j] = 1 if grid[i][j] == 1 and (j == 0 or dp[3][i][j-1] == 0) else 0
        ans = 0
        for i in range(n):
            for j in range(n):
                ans = max(ans, min(dp[0][i][j], dp[1][i][j], dp[2][i][j], dp[3][i][j]))
        return ans