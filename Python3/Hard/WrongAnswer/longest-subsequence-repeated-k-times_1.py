class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        
        n = len(s)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for l in range(2, n+1):
            for i in range(n-l+1):
                j = i + l - 1
                if l == 2 and s[i] == s[j]:
                    dp[i][j] = 2
                elif s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1] + 2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        def dfs(i, j, k):
            if i > j:
                return ''
            if i == j:
                return s[i] * (k // dp[i][j])
            if s[i] == s[j]:
                if dp[i+1][j-1] + 2 == dp[i][j] and k % dp[i][j] == 0:
                    return s[i] + dfs(i+1, j-1, k - 2) + s[j]
                else:
                    return max(dfs(i+1, j, k), dfs(i, j-1, k), key = lambda x: (len(x), x))
            else:
                return max(dfs(i+1, j, k), dfs(i, j-1, k), key = lambda x: (len(x), x))
        return dfs(0, n-1, k)