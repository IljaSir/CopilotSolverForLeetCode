class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        
        timePoints = sorted(timePoints)
        min_diff = 24*60
        for i in range(len(timePoints)-1):
            diff = self.get_diff(timePoints[i], timePoints[i+1])
            if diff < min_diff:
                min_diff = diff
        diff = self.get_diff(timePoints[0], timePoints[-1])
        if diff < min_diff:
            min_diff = diff
        return min_diff