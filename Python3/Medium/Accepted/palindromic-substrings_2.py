class Solution:
    def countSubstrings(self, s: str) -> int:
        
        n = len(s)
        dp = [[False]*n for _ in range(n)]
        ans = 0
        for i in range(n):
            dp[i][i] = True
            ans += 1
        for i in range(n-1):
            if s[i] == s[i+1]:
                dp[i][i+1] = True
                ans += 1
        for l in range(3, n+1):
            for i in range(n-l+1):
                j = i+l-1
                if dp[i+1][j-1] and s[i] == s[j]:
                    dp[i][j] = True
                    ans += 1
        return ans