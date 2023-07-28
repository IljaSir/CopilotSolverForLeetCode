class Solution:
    def numDecodings(self, s: str) -> int:
        
        if s[0] == '0':
            return 0
        dp = [0] * (len(s) + 1)
        dp[0] = 1
        dp[1] = 9 if s[0] == '*' else 1
        for i in range(1, len(s)):
            if s[i] == '*':
                dp[i + 1] += 9 * dp[i]
                if s[i - 1] == '1':
                    dp[i + 1] += 9 * dp[i - 1]
                elif s[i - 1] == '2':
                    dp[i + 1] += 6 * dp[i - 1]
                elif s[i - 1] == '*':
                    dp[i + 1] += 15 * dp[i - 1]
            else:
                if s[i] != '0':
                    dp[i + 1] += dp[i]
                if s[i - 1] == '1':
                    dp[i + 1] += dp[i - 1]
                elif s[i - 1] == '2' and s[i] <= '6':
                    dp[i + 1] += dp[i - 1]
                elif s[i - 1] == '*':
                    dp[i + 1] += (2 if s[i] <= '6' else 1) * dp[i - 1]
            dp[i + 1] %= 1000000007
        return dp[-1]