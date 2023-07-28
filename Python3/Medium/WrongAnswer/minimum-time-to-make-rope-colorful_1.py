class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        
        N = len(colors)
        dp = [[0, 0, 0] for _ in range(N)]
        dp[0][ord(colors[0]) - ord('a')] = neededTime[0]
        for i in range(1, N):
            c = colors[i]
            for j in range(3):
                if c == chr(ord('a') + j):
                    dp[i][j] = dp[i - 1][j] + neededTime[i]
                else:
                    dp[i][j] = min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + neededTime[i]
        return min(dp[-1])