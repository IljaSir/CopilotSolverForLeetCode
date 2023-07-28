class Solution:
    def minCut(self, s: str) -> int:
        
        if s == s[::-1]:
            return 0
        n = len(s)
        dp = [0] * n
        for i in range(n):
            if s[:i+1] == s[:i+1][::-1]:
                continue
            dp[i] = min([dp[j] for j in range(i) if s[j+1:i+1] == s[j+1:i+1][::-1]]) + 1
        return dp[-1]