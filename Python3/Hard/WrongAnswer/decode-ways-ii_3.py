class Solution:
    def numDecodings(self, s: str) -> int:
        
        # dp[i] = num of ways to decode s[:i]
        # dp[i] = dp[i-1] * (1 if s[i-1] in '123456789' else 9) + dp[i-2] * (9 if s[i-2] == '1' else 6 if s[i-2] == '2' else 15 if s[i-2] == '*' else 0)
        # dp[0] = 1
        # dp[1] = 9 if s[0] == '*' else 1 if s[0] in '123456789' else 0
        MOD = 10**9 + 7
        dp = [0] * (len(s) + 1)
        dp[0] = 1
        dp[1] = 9 if s[0] == '*' else 1 if s[0] in '123456789' else 0
        for i in range(2, len(s) + 1):
            if s[i-1] in '123456789':
                dp[i] += dp[i-1]
            else:
                dp[i] += dp[i-1] * 9
            if s[i-2] == '1':
                dp[i] += dp[i-2]
            elif s[i-2] == '2':
                dp[i] += dp[i-2] * 6
            elif s[i-2] == '*':
                dp[i] += dp[i-2] * 15
            dp[i] %= MOD
        return dp[-1]