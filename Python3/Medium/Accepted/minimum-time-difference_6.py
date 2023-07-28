class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        timePoints = sorted(timePoints, key=lambda x: int(x.split(':')[0])*60+int(x.split(':')[1]))
        ans = 1440
        for i in range(len(timePoints)-1):
            ans = min(ans, (int(timePoints[i+1].split(':')[0])*60+int(timePoints[i+1].split(':')[1])) - (int(timePoints[i].split(':')[0])*60+int(timePoints[i].split(':')[1])))
        return min(ans, (int(timePoints[0].split(':')[0])*60+int(timePoints[0].split(':')[1]) + 1440) - (int(timePoints[-1].split(':')[0])*60+int(timePoints[-1].split(':')[1])))