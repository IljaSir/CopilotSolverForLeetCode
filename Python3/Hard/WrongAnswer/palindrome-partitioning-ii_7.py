class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [0] * n
        for i in range(n):
            dp[i] = i
        for i in range(n):
            j = 0
            while i - j >= 0 and i + j < n and s[i - j] == s[i + j]:
                if i - j == 0:
                    dp[i + j] = 0
                else:
                    dp[i + j] = min(dp[i + j], dp[i - j - 1] + 1)
                j += 1
            j = 1
            while i - j + 1 >= 0 and i + j < n and s[i - j + 1] == s[i + j]:
                dp[i + j] = min(dp[i + j], dp[i - j] + 1)
                j += 1
        return dp[n - 1]