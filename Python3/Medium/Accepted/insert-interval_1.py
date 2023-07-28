class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        i = 0
        while i < len(intervals):
            if intervals[i][0] > newInterval[1]:
                intervals.insert(i, newInterval)
                return intervals
            elif intervals[i][1] < newInterval[0]:
                i += 1
                continue
            else:
                newInterval[0] = min(newInterval[0], intervals[i][0])
                newInterval[1] = max(newInterval[1], intervals[i][1])
                intervals.pop(i)
        intervals.append(newInterval)
        return intervals