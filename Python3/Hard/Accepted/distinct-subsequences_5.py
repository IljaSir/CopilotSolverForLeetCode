class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        
        ls, lt = len(s), len(t)
        if ls < lt:
            return 0
        if ls == lt:
            if s == t:
                return 1
            else:
                return 0
        dp = [[0 for _ in range(lt)] for _ in range(ls)]
        if s[0] == t[0]:
            dp[0][0] = 1
        for i in range(1, ls):
            dp[i][0] = dp[i-1][0]
            if s[i] == t[0]:
                dp[i][0] += 1
        for i in range(1, ls):
            for j in range(1, lt):
                dp[i][j] = dp[i-1][j]
                if s[i] == t[j]:
                    dp[i][j] += dp[i-1][j-1]
        return dp[-1][-1]