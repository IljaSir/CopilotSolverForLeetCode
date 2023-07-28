class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [i for i in range(n)]
        for i in range(n):
            # odd
            j = 0
            while i-j >= 0 and i+j < n and s[i-j] == s[i+j]:
                if i-j == 0:
                    dp[i+j] = 0
                else:
                    dp[i+j] = min(dp[i+j], dp[i-j-1]+1)
                j += 1
            # even
            j = 0
            while i-j >= 0 and i+j+1 < n and s[i-j] == s[i+j+1]:
                if i-j == 0:
                    dp[i+j+1] = 0
                else:
                    dp[i+j+1] = min(dp[i+j+1], dp[i-j-1]+1)
                j += 1
        return dp[n-1]