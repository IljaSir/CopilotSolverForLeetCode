class Solution:
    def numDecodings(self, s: str) -> int:
        
        if s[0] == '0':
            return 0
        if len(s) == 1:
            return 1
        dp = [0] * len(s)
        dp[0] = 1
        if int(s[0:2]) <= 26 and s[1] != '0':
            dp[1] = 2
        elif s[1] == '0' and int(s[0:2]) <= 26:
            dp[1] = 1
        else:
            dp[1] = 1
        for i in range(2, len(s)):
            if s[i] == '0' and s[i-1] == '0':
                return 0
            if s[i] != '0':
                dp[i] += dp[i-1]
            if s[i-1] != '0' and int(s[i-1:i+1]) <= 26:
                dp[i] += dp[i-2]
        return dp[-1]