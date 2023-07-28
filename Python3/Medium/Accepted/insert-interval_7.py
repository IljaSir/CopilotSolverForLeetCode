class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        if not intervals:
            return [newInterval]
        if not newInterval:
            return intervals
        start, end = newInterval
        left = [i for i in intervals if i[1] < start]
        right = [i for i in intervals if i[0] > end]
        if len(left) + len(right) < len(intervals):
            start = min(start, intervals[len(left)][0])
            end = max(end, intervals[~len(right)][1])
        return left + [[start, end]] + right