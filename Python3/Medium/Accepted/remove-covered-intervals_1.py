class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        right = 0
        count = 0
        for i in range(len(intervals)):
            if intervals[i][1] > right:
                count += 1
                right = intervals[i][1]
        return count