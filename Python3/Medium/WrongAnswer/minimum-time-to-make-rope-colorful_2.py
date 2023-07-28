class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        
        n = len(colors)
        dp = [[0] * 26 for _ in range(n)]
        for i in range(n):
            for j in range(26):
                dp[i][j] = neededTime[i] + (dp[i - 1][j] if i > 0 else 0)
            dp[i][ord(colors[i]) - ord('a')] = min(dp[i][ord(colors[i]) - ord('a')], dp[i - 1][ord(colors[i]) - ord('a')] if i > 0 else 0)
        return min(dp[n - 1])