class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        timePoints = [int(x[:2]) * 60 + int(x[3:]) for x in timePoints]
        timePoints.sort()
        timePoints.append(timePoints[0] + 1440)
        return min((timePoints[i] - timePoints[i - 1]) for i in range(1, len(timePoints)))