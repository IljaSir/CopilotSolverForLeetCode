class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: x[0])
        last = -10**9
        count = 0
        for i, j in intervals:
            if i < last:
                count += 1
                last = min(last, j)
            else:
                last = j
        return count