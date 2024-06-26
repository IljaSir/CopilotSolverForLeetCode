class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        # dp[i][j] = dp[i-1][j-1] if p[j] == s[i] or p[j] == '.'
        # dp[i][j] = dp[i-1][j] or dp[i][j-2] if p[j] == '*'
        # dp[i][j] = dp[i][j-2] if p[j] == '*' and p[j-1] != s[i]
        n, m = len(s), len(p)
        dp = [[False] * (m + 1) for _ in range(n + 1)]
        dp[0][0] = True
        for j in range(2, m + 1):
            dp[0][j] = dp[0][j - 2] and p[j - 1] == '*'
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if p[j - 1] == s[i - 1] or p[j - 1] == '.':
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    if p[j - 2] == s[i - 1] or p[j - 2] == '.':
                        dp[i][j] = dp[i - 1][j] or dp[i][j - 2]
                    else:
                        dp[i][j] = dp[i][j - 2]
        return dp[n][m]