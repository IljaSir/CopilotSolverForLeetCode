class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: x[1])
        res = 0
        prev = -10**9
        for start, end in intervals:
            if start >= prev:
                res += 1
                prev = end
        return len(intervals) - res