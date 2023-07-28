class Solution:
    def minCut(self, s: str) -> int:
        
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = True
        for i in range(n - 1):
            dp[i][i + 1] = s[i] == s[i + 1]
        for i in range(n - 3, -1, -1):
            for j in range(i + 2, n):
                dp[i][j] = dp[i + 1][j - 1] and s[i] == s[j]
        f = [float('inf')] * n
        for i in range(n):
            if dp[0][i]:
                f[i] = 0
            else:
                for j in range(i):
                    if dp[j + 1][i]:
                        f[i] = min(f[i], f[j] + 1)
        return f[n - 1]