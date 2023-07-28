class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        events.sort(key=lambda x: x[1])
        dp = [0] * (len(events) + 1)
        for i in range(len(events)):
            dp[i + 1] = max(dp[i], events[i][2])
            for j in range(i - 1, -1, -1):
                if events[j][1] <= events[i][0]:
                    dp[i + 1] = max(dp[i + 1], dp[j + 1] + events[i][2])
                    break
        return dp[-1]