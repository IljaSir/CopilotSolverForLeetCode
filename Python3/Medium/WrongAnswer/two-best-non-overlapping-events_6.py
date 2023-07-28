class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        
        # Sort events by start time
        events.sort(key=lambda x: x[0])
        # dp[i] = max value of two events ending at time i
        dp = [0] * (10**5 + 1)
        # max_value = max value of two events ending at time i
        max_value = 0
        # max_end_time = max end time of two events ending at time i
        max_end_time = 0
        for start_time, end_time, value in events:
            # If the start time of the current event is after the max end time of two events ending at time i, then we can add the current event to the two events ending at time i
            if start_time > max_end_time:
                dp[end_time] = max_value + value
            # Otherwise, we can replace the event ending at time i with the current event
            else:
                dp[end_time] = max_value - dp[max_end_time] + value + dp[max_end_time]
            # Update max_value and max_end_time
            if dp[end_time] > max_value:
                max_value = dp[end_time]
                max_end_time = end_time
        return max_value