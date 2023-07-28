class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        
        banned = set(banned)
        dp = [[0] * (n + 1) for _ in range(maxSum + 1)]
        for i in range(1, n + 1):
            dp[1][i] = 1
        for i in range(1, maxSum + 1):
            for j in range(1, n + 1):
                dp[i][j] = dp[i][j - 1]
                if i - j >= 1 and j not in banned:
                    dp[i][j] += dp[i - j][j - 1]
        return dp[maxSum][n]