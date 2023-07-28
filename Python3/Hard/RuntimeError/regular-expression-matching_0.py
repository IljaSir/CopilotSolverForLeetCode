class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        m, n = len(s), len(p)
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        dp[0][0] = True
        for i in range(m + 1):
            for j in range(1, n + 1):
                if p[j - 1] == '*':
                    dp[i][j] = dp[i][j - 2]
                    if matches(s, p, i, j - 1):
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
                else:
                    if matches(s, p, i, j):
                        dp[i][j] = dp[i - 1][j - 1]
        return dp[m][n]