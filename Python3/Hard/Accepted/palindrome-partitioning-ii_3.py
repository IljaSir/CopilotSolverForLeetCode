class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        for i in range(n-1, -1, -1):
            for j in range(i+1, n):
                if s[i] == s[j]:
                    if j-i == 1:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i+1][j-1]
        cuts = [0]*n
        for i in range(n):
            if dp[0][i]:
                cuts[i] = 0
            else:
                cuts[i] = cuts[i-1] + 1
                for j in range(i-1, -1, -1):
                    if dp[j][i]:
                        cuts[i] = min(cuts[i], cuts[j-1]+1)
        return cuts[-1]