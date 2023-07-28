class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        # find the index of the first interval that is greater than newInterval
        # if no such interval is found, then append newInterval to the end of intervals
        i = 0
        while i < len(intervals):
            if intervals[i][0] > newInterval[0]:
                break
            i += 1
        intervals.insert(i, newInterval)
        # merge intervals
        i = 0
        while i < len(intervals) - 1:
            if intervals[i][1] >= intervals[i+1][0]:
                intervals[i][1] = max(intervals[i][1], intervals[i+1][1])
                intervals.pop(i+1)
            else:
                i += 1
        return intervals