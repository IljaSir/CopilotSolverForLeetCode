class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        
        intervals.sort()
        res = 0
        while intervals:
            res += 1
            left, right = intervals[0]
            intervals = intervals[1:]
            while intervals:
                if intervals[0][0] <= right <= intervals[0][1]:
                    intervals = intervals[1:]
                else:
                    break
        return res