class Solution:
    def countSubstrings(self, s: str) -> int:
        
        n = len(s)
        dp = [[0]*n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = 1
        for l in range(2,n):
            for i in range(n-l):
                if s[i] == s[i+l] and dp[i+1][i+l-1] == 1:
                    dp[i][i+l] = 1
        return sum([sum(r) for r in dp])