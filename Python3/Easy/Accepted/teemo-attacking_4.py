class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        if not timeSeries:
            return 0
        if len(timeSeries) == 1:
            return duration
        total_time = 0
        for i in range(len(timeSeries) - 1):
            if timeSeries[i + 1] > timeSeries[i] + duration:
                total_time += duration
            else:
                total_time += timeSeries[i + 1] - timeSeries[i]
        return total_time + duration