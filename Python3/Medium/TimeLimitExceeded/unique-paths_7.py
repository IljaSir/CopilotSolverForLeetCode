class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        # 1. Brute Force
        # 2. DP
        # 3. Math
        # 4. Binomial Coefficients
        # 5. Fibonacci Number
        # 6. Combination

        # 1. Brute Force
        def dfs(i, j):
            if i == m - 1 and j == n - 1:
                return 1
            if i >= m or j >= n:
                return 0
            return dfs(i + 1, j) + dfs(i, j + 1)

        return dfs(0, 0)

        # 2. DP
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                if i == 0:
                    dp[i][j] = dp[i][j - 1]
                elif j == 0:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

        # 3. Math
        # 4. Binomial Coefficients
        # 5. Fibonacci Number
        # 6. Combination