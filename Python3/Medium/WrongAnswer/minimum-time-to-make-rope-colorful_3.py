class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        
        n = len(colors)
        dp = [0]*n
        for i in range(1, n):
            if colors[i] == colors[i-1]:
                dp[i] = neededTime[i] + min(dp[i-1], dp[i-2] if i >= 2 else 0)
            else:
                dp[i] = neededTime[i] + dp[i-1]
        return min(dp[-1], dp[-2])