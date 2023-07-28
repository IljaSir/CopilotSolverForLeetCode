class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        
        # Approach 1: DP
        # Time  complexity: O(m*n)
        # Space complexity: O(m*n)
        # m, n = len(s), len(t)
        # dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        # for i in range(m):
        #     for j in range(n):
        #         if s[i] == t[j]:
        #             dp[i+1][j+1] = dp[i][j] + 1
        #         else:
        #             dp[i+1][j+1] = dp[i][j+1]
        # return n - max(dp[m])

        # Approach 2: Greedy
        # Time  complexity: O(m*n)
        # Space complexity: O(1)
        # m, n = len(s), len(t)
        # i, j = 0, 0
        # while i < m and j < n:
        #     if s[i] == t[j]:
        #         j += 1
        #     i += 1
        # return n - j

        # Approach 3: Binary Search
        # Time  complexity: O(m*log(n))
        # Space complexity: O(n)
        m, n = len(s), len(t)
        dp = [[] for _ in range(n)]
        for i, c in enumerate(s):
            for j, d in enumerate(t):
                if c == d:
                    dp[j].append(i)
        if not dp[-1]: return -1
        res = dp[-1][0] + 1
        for i in range(n-2, -1, -1):
            if not dp[i]: return -1
            j = bisect.bisect_left(dp[i], dp[i+1][0])
            if j == len(dp[i]): return -1
            res += dp[i][j] - dp[i+1][0] + 1
        return m - res