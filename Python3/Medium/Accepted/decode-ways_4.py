class Solution:
    def numDecodings(self, s: str) -> int:
        
        if s[0] == '0':
            return 0
        if len(s) == 1:
            return 1
        dp = [0] * len(s)
        dp[0] = 1
        for i in range(1, len(s)):
            if s[i] != '0':
                dp[i] += dp[i-1]
            if s[i-1:i+1] >= '10' and s[i-1:i+1] <= '26':
                dp[i] += dp[i-2] if i-2 >= 0 else 1
        return dp[-1]