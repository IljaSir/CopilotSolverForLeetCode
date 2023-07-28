class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if s[i] == s[j] and (j - i < 2 or dp[i + 1][j - 1]):
                    dp[i][j] = 1
        cuts = [n] * n
        for i in range(n - 1, -1, -1):
            if dp[i][n - 1]:
                cuts[i] = 0
            else:
                for j in range(i + 1, n):
                    if dp[i][j - 1]:
                        cuts[i] = min(cuts[i], cuts[j] + 1)
        return cuts[0]