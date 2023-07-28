class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        
        n = len(colors)
        dp = [0] * n
        for i in range(n):
            dp[i] = [float('inf')] * 26
        for i in range(n):
            for j in range(26):
                if colors[i] != chr(ord('a') + j):
                    dp[i][j] = neededTime[i]
                if i > 0:
                    for k in range(26):
                        if k != j:
                            dp[i][j] = min(dp[i][j], dp[i-1][k] + neededTime[i])
        return min(dp[n-1])