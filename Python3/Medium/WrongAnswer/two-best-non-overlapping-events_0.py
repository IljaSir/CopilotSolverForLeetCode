class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        events.sort(key = lambda x: x[1])
        dp = [0] * len(events)
        dp[0] = events[0][2]
        for i in range(1, len(events)):
            dp[i] = max(dp[i - 1], events[i][2])
            for j in range(i - 1, -1, -1):
                if events[j][1] < events[i][0]:
                    dp[i] = max(dp[i], events[i][2] + dp[j])
                    break
        return max(dp)