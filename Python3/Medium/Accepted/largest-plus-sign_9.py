class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        
        grid = [[1]*n for i in range(n)]
        for x,y in mines:
            grid[x][y] = 0
        dp = [[[0]*n for i in range(n)] for j in range(4)]
        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    if i:
                        dp[0][i][j] = dp[0][i-1][j]+1
                    else:
                        dp[0][i][j] = 1
                    if j:
                        dp[1][i][j] = dp[1][i][j-1]+1
                    else:
                        dp[1][i][j] = 1
        for i in range(n-1,-1,-1):
            for j in range(n-1,-1,-1):
                if grid[i][j]:
                    if i<n-1:
                        dp[2][i][j] = dp[2][i+1][j]+1
                    else:
                        dp[2][i][j] = 1
                    if j<n-1:
                        dp[3][i][j] = dp[3][i][j+1]+1
                    else:
                        dp[3][i][j] = 1
        ans = 0
        for i in range(n):
            for j in range(n):
                if grid[i][j]:
                    ans = max(ans, min(dp[0][i][j], dp[1][i][j], dp[2][i][j], dp[3][i][j]))
        return ans