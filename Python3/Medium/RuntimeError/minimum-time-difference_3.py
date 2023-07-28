class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        timePoints = sorted(timePoints)
        minDiff = 24 * 60
        for i in range(len(timePoints) - 1):
            time1 = timePoints[i]
            time2 = timePoints[i + 1]
            diff = self.timeDiff(time1, time2)
            minDiff = min(minDiff, diff)
            
        diff = self.timeDiff(timePoints[0], timePoints[-1])
        minDiff = min(minDiff, diff)
        return minDiff