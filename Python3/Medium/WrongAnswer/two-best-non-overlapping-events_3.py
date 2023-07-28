class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        events.sort(key=lambda x: x[0])
        n = len(events)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if events[i][1] <= events[j][0]:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + events[i][2] + events[j][2])
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[n - 1][n - 1]