class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        
        n = len(stones)
        dp = [[0] * n for _ in range(n)]
        s = [0] * (n + 1)
        for i in range(n):
            s[i + 1] = s[i] + stones[i]
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[i][j] = max(s[j + 1] - s[i + 1] - dp[i + 1][j], s[j] - s[i] - dp[i][j - 1])
        return dp[0][n - 1]