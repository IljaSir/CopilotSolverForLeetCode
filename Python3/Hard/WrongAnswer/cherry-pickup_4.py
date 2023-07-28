class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        dp = [[0]*n for _ in range(n)]
        dp[0][0] = grid[0][0]
        for t in range(1, 2*n-1):
            dp2 = [[0]*n for _ in range(n)]
            for i in range(n):
                for p in range(n):
                    j, q = t-i, t-p
                    if j<0 or j>=n or q<0 or q>=n or grid[i][j]<0 or grid[p][q]<0:
                        dp2[i][p] = -1
                        continue
                    if i > 0:
                        dp2[i][p] = max(dp2[i][p], dp[i-1][p])
                    if p > 0:
                        dp2[i][p] = max(dp2[i][p], dp[i][p-1])
                    if i > 0 and p > 0:
                        dp2[i][p] = max(dp2[i][p], dp[i-1][p-1])
                    if dp2[i][p] >= 0:
                        dp2[i][p] += grid[i][j]
                        if i != p:
                            dp2[i][p] += grid[p][q]
            dp = dp2
        return max(0, dp[n-1][n-1])