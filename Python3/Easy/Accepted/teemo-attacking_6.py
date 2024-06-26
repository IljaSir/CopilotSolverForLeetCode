class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        if not timeSeries:
            return 0
        if duration == 0:
            return 0
        if len(timeSeries) == 1:
            return duration
        total = 0
        for i in range(len(timeSeries)-1):
            total += min(timeSeries[i+1] - timeSeries[i], duration)
        return total + duration