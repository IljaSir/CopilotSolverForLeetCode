class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        if not timeSeries:
            return 0
        if len(timeSeries) == 1:
            return duration
        total = 0
        for i in range(len(timeSeries) - 1):
            if timeSeries[i] + duration > timeSeries[i + 1]:
                total += timeSeries[i + 1] - timeSeries[i]
            else:
                total += duration
        return total + duration