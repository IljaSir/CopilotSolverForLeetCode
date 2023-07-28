class Solution:
    def numTrees(self, n: int) -> int:
        
        if n == 1:
            return 1
        elif n == 2:
            return 2
        elif n == 3:
            return 5
        dp = [0] * (n + 1)
        dp[0], dp[1], dp[2], dp[3] = 1, 1, 2, 5
        for i in range(4, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]
        return dp[n]