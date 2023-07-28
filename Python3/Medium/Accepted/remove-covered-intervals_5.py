class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        print(intervals)
        count = 0
        end = 0
        for i in range(len(intervals)):
            if intervals[i][1] > end:
                end = intervals[i][1]
                count += 1
        return count