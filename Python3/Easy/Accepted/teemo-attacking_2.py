class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        if not timeSeries:
            return 0
        if len(timeSeries) == 1:
            return duration
        res = 0
        for i in range(1, len(timeSeries)):
            if timeSeries[i] - timeSeries[i - 1] >= duration:
                res += duration
            else:
                res += timeSeries[i] - timeSeries[i - 1]
        return res + duration