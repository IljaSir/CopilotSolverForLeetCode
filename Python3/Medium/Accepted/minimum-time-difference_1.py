class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        timePoints = sorted([int(i[:2])*60+int(i[3:]) for i in timePoints])
        timePoints.append(timePoints[0]+1440)
        return min([timePoints[i+1]-timePoints[i] for i in range(len(timePoints)-1)])