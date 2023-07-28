class Solution:
    def countSubstrings(self, s: str) -> int:
        
        n = len(s)
        dp = [[0]*n for _ in range(n)]
        res = 0
        for i in range(n):
            dp[i][i] = 1
            res += 1
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = 1
                res += 1
        for k in range(2, n):
            for i in range(n-k):
                j = i+k
                if s[i] == s[j] and dp[i+1][j-1]:
                    dp[i][j] = 1
                    res += 1
        return res