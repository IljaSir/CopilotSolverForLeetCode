class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        # If the new interval is before the first interval, insert it as the first interval
        if intervals[0][0] > newInterval[1]:
            return [newInterval] + intervals
        # If the new interval is after the last interval, insert it as the last interval
        if intervals[-1][1] < newInterval[0]:
            return intervals + [newInterval]
        # Find the index of the interval that starts after the new interval
        i = 0
        while intervals[i][0] < newInterval[0]:
            i += 1
        # If the new interval starts before the first interval, merge the new interval with the first interval
        if i == 0:
            intervals[0][0] = newInterval[0]
            intervals[0][1] = max(newInterval[1], intervals[0][1])
        # If the new interval starts after the first interval, insert the new interval before the first interval
        else:
            intervals.insert(i, newInterval)
        # Merge the intervals
        i = 0
        while i < len(intervals) - 1:
            if intervals[i][1] < intervals[i + 1][0]:
                i += 1
            else:
                intervals[i][0] = min(intervals[i][0], intervals[i + 1][0])
                intervals[i][1] = max(intervals[i][1], intervals[i + 1][1])
                intervals.pop(i + 1)
        return intervals