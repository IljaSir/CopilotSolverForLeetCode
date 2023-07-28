class Solution:
    def numDecodings(self, s: str) -> int:
        
        MOD = 10**9+7
        n = len(s)
        dp = [0]*(n+1)
        dp[0] = 1
        for i in range(n):
            if s[i] == '0':
                if i == 0:
                    return 0
                elif s[i-1] == '1' or s[i-1] == '2':
                    dp[i] = dp[i-2]
                elif s[i-1] == '*':
                    dp[i] = dp[i-2]*2
                else:
                    return 0
            elif s[i] == '*':
                dp[i] = dp[i-1]*9
                if i > 0:
                    if s[i-1] == '1':
                        dp[i] += dp[i-2]*9
                    elif s[i-1] == '2':
                        dp[i] += dp[i-2]*6
                    elif s[i-1] == '*':
                        dp[i] += dp[i-2]*15
            else:
                dp[i] = dp[i-1]
                if i > 0:
                    if s[i-1] == '1' or (s[i-1] == '2' and s[i] <= '6'):
                        dp[i] += dp[i-2]
                    elif s[i-1] == '*':
                        dp[i] += dp[i-2]*(2 if s[i] <= '6' else 1)
            dp[i] %= MOD
        return dp[n-1]