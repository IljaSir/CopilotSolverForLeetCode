class Solution:
    def numDecodings(self, s: str) -> int:
        
        if s[0] == "0":
            return 0
        dp = [1, 1]
        for i in range(1, len(s)):
            if s[i] == "0":
                if s[i-1] == "1" or s[i-1] == "2":
                    dp.append(dp[i-1])
                else:
                    return 0
            elif s[i-1] == "1" or (s[i-1] == "2" and 0 < int(s[i]) < 7):
                dp.append(dp[i] + dp[i-1])
            else:
                dp.append(dp[i])
        return dp[-1]