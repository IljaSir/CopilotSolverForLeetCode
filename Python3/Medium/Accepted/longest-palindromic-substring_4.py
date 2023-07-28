class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        if n <= 1:
            return s
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                if s[i] == s[j]:
                    if j - i == 1:
                        dp[i][j] = 2
                    elif dp[i + 1][j - 1] > 0:
                        dp[i][j] = dp[i + 1][j - 1] + 2
                else:
                    dp[i][j] = 0
        max_len, res = 0, ''
        for i in range(n):
            for j in range(i, n):
                if dp[i][j] > max_len:
                    max_len = dp[i][j]
                    res = s[i:j + 1]
        return res