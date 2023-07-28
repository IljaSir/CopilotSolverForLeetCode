class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m, n = len(grid), len(grid[0])
        dp = [[False for _ in range(n)] for _ in range(m)]
        dp[0][0] = True
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                if i > 0 and dp[i - 1][j]:
                    if grid[i - 1][j] == '/':
                        if grid[i][j] == '/':
                            dp[i][j] = True
                    elif grid[i - 1][j] == '\\':
                        if grid[i][j] == '\\':
                            dp[i][j] = True
                    elif grid[i - 1][j] == '(' or grid[i - 1][j] == ')':
                        if grid[i][j] == '(' or grid[i][j] == ')':
                            dp[i][j] = True
                if j > 0 and dp[i][j - 1]:
                    if grid[i][j - 1] == '/':
                        if grid[i][j] == '\\':
                            dp[i][j] = True
                    elif grid[i][j - 1] == '\\':
                        if grid[i][j] == '/':
                            dp[i][j] = True
                    elif grid[i][j - 1] == '(':
                        if grid[i][j] == ')':
                            dp[i][j] = True
                    elif grid[i][j - 1] == ')':
                        if grid[i][j] == '(':
                            dp[i][j] = True
        return dp[m - 1][n - 1]