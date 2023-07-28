class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: (x[0], -x[1]))
        res = 0
        prev = [0, 0]
        for start, end in intervals:
            if start > prev[0] and end > prev[1]:
                res += 1
            prev = [start, end]
        return res