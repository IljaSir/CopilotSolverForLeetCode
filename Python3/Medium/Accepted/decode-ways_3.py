class Solution:
    def numDecodings(self, s: str) -> int:
        
        if not s or s[0] == '0':
            return 0
        if len(s) == 1:
            return 1
        dp = [0] * len(s)
        dp[0] = 1
        for i in range(1, len(s)):
            if s[i] == '0':
                if s[i-1] == '1' or s[i-1] == '2':
                    dp[i] = dp[i-2] if i >= 2 else 1
                else:
                    return 0
            else:
                dp[i] += dp[i-1]
                if s[i-1] == '1' or (s[i-1] == '2' and s[i] <= '6'):
                    dp[i] += dp[i-2] if i >= 2 else 1
        return dp[-1]