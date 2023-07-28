class Solution:
    def countPalindromes(self, s: str) -> int:
        
        # https://leetcode.com/problems/count-palindromic-subsequences/discuss/106614/JavaC%2B%2BPython-DP-Solution
        # dp[i][j] = number of palindromic subsequences in s[i:j]
        # dp[i][j] = 2 * dp[i+1][j-1] + 2, if s[i] == s[j]
        # dp[i][j] = 2 * dp[i+1][j-1] - dp[i+1][j-1], if s[i] == s[j]
        # dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1], if s[i] != s[j]
        # dp[i][i] = 1
        # dp[i][i+1] = 2 if s[i] == s[i+1]
        # dp[i][i+1] = 1 if s[i] != s[i+1]
        M = 10**9 + 7
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for i in range(n-1):
            dp[i][i+1] = 3 if s[i] == s[i+1] else 2
        for l in range(3, n+1):
            for i in range(n-l+1):
                j = i + l - 1
                if s[i] == s[j]:
                    dp[i][j] = 2 * dp[i+1][j-1] + 2
                else:
                    dp[i][j] = 2 * dp[i+1][j-1] - dp[i+1][j-1]
                dp[i][j] %= M
        return (dp[0][n-1] + M) % M