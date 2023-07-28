class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        # 1. Find the time series of the poison
        # 2. Find the total time of the poison
        # 3. Return the total time of the poison
        # 4. If the time series is empty, return 0
        if not timeSeries:
            return 0
        # 5. Find the time series of the poison
        poison_time_series = []
        for i in range(len(timeSeries)):
            poison_time_series.extend(list(range(timeSeries[i], timeSeries[i] + duration)))
        # 6. Find the total time of the poison
        total_time = len(poison_time_series)
        # 7. Return the total time of the poison
        return total_time