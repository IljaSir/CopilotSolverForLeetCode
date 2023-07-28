class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        
        len_s = len(s)
        len_t = len(t)
        dp = [[0] * (len_s + 1) for _ in range(len_t + 1)]
        for i in range(len_s + 1):
            dp[0][i] = 1
        for i in range(1, len_t + 1):
            for j in range(1, len_s + 1):
                dp[i][j] = dp[i][j - 1]
                if s[j - 1] == t[i - 1]:
                    dp[i][j] += dp[i - 1][j - 1]
        return dp[-1][-1]