class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        minutes = []
        for time in timePoints:
            minutes.append(int(time[0:2]) * 60 + int(time[3:]))
        minutes.sort()
        min_diff = 24*60
        for i in range(len(minutes)-1):
            min_diff = min(minutes[i+1] - minutes[i], min_diff)
        return min(min_diff, minutes[0] + 24*60 - minutes[-1])