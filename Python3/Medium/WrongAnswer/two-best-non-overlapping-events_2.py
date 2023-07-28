class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        events.sort(key=lambda x: (x[0], x[1]))
        dp = [[0, 0, 0] for _ in range(len(events))]
        dp[0] = [0, events[0][2], events[0][1]]
        for i in range(1, len(events)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
            dp[i][1] = max(dp[i-1][0]+events[i][2], dp[i-1][1])
            for j in range(i-1, -1, -1):
                if events[j][1] < events[i][0]:
                    dp[i][2] = max(dp[i][2], dp[j][0]+events[i][2])
                    break
        return max(dp[-1])