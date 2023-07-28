class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [i for i in range(n)]
        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j] and (i-j <= 2 or dp[j+1] < i):
                    dp[i] = min(dp[i], dp[j-1] + 1 if j > 0 else 0)
        return dp[-1]