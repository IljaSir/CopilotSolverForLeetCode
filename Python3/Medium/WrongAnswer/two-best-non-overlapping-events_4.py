class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        
        events.sort(key=lambda x: x[1])
        dp = [0] * (len(events) + 1)
        for i in range(1, len(events) + 1):
            dp[i] = max(dp[i - 1], events[i - 1][2])
            for j in range(i):
                if events[j][1] <= events[i - 1][0]:
                    dp[i] = max(dp[i], dp[j] + events[i - 1][2])
                    break
        return dp[-1]