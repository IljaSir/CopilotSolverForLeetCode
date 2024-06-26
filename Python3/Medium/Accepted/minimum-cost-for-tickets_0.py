class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        # dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1], dp[i-30] + costs[2])
        dp = [0] * (days[-1] + 1)
        day_set = set(days)
        for i in range(days[0], days[-1] + 1):
            if i not in day_set:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[i-1] + costs[0], dp[max(0, i-7)] + costs[1], dp[max(0, i-30)] + costs[2])
        return dp[-1]