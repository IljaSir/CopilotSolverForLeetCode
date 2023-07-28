class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        def convert(time):
            h,m = time.split(':')
            return int(h)*60+int(m)
        timePoints = sorted(list(map(convert, timePoints)))
        return min((timePoints[i+1]-timePoints[i])%1440 for i in range(len(timePoints)-1))