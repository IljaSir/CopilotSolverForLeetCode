class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        end = 0
        count = 0
        for start, e in intervals:
            if e > end:
                end = e
                count += 1
        return count