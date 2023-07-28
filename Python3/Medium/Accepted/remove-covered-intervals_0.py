class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        count = len(intervals)
        right = intervals[0][1]
        for i in range(1, len(intervals)):
            if intervals[i][1] <= right:
                count -= 1
            else:
                right = intervals[i][1]
        return count