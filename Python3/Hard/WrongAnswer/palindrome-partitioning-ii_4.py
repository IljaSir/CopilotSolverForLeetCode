class Solution:
    def minCut(self, s: str) -> int:
        
        N = len(s)
        dp = [i for i in range(N)]
        for i in range(N):
            j = 0
            while i - j >= 0 and i + j < N and s[i - j] == s[i + j]:
                if i - j == 0:
                    dp[i + j] = 0
                else:
                    dp[i + j] = min(dp[i + j], dp[i - j - 1] + 1)
                j += 1
            j = 1
            while i - j + 1 >= 0 and i + j < N and s[i - j + 1] == s[i + j]:
                dp[i + j] = min(dp[i + j], dp[i - j] + 1)
                j += 1
        return dp[N - 1]