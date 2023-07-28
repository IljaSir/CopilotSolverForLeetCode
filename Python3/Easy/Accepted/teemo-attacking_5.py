class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        
        if len(timeSeries) == 0:
            return 0
        if len(timeSeries) == 1:
            return duration
        total_time = 0
        for i in range(len(timeSeries)):
            if i == len(timeSeries) - 1:
                total_time += duration
            else:
                if timeSeries[i + 1] - timeSeries[i] < duration:
                    total_time += timeSeries[i + 1] - timeSeries[i]
                else:
                    total_time += duration
        return total_time