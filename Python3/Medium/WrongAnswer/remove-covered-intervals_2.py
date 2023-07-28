class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        count = 0
        end = 0
        for start, end in intervals:
            if end > end:
                count += 1
                end = end
        return count