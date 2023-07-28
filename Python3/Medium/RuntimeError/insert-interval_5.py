class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        if not intervals:
            return [newInterval]
        if not newInterval:
            return intervals
        if newInterval[0] > intervals[-1][1]:
            intervals.append(newInterval)
            return intervals
        if newInterval[1] < intervals[0][0]:
            intervals.insert(0, newInterval)
            return intervals
        i = 0
        while i < len(intervals):
            if newInterval[0] >= intervals[i][0] and newInterval[0] <= intervals[i][1]:
                break
            i += 1
        j = i
        while j < len(intervals):
            if newInterval[1] >= intervals[j][0] and newInterval[1] <= intervals[j][1]:
                break
            j += 1
        if i == j:
            intervals.insert(i, newInterval)
        else:
            intervals[i][0] = min(intervals[i][0], newInterval[0])
            intervals[j][1] = max(intervals[j][1], newInterval[1])
            intervals = intervals[:i+1] + intervals[j+1:]
        return intervals