class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        
        # dp[i][0] = min flips to make s[:i] monotone increasing with s[i] = 0
        # dp[i][1] = min flips to make s[:i] monotone increasing with s[i] = 1
        dp = [[0, 0] for _ in range(len(s))]
        dp[0][0] = 1 if s[0] == '1' else 0
        dp[0][1] = 0
        for i in range(1, len(s)):
            dp[i][0] = dp[i - 1][0] + (1 if s[i] == '1' else 0)
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + (0 if s[i] == '1' else 1)
        return min(dp[-1])