class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        # sort by start time
        intervals.sort(key=lambda x: x[0])
        # print(intervals)
        res = [intervals[0]]
        for i in range(1, len(intervals)):
            # print(i, res)
            if res[-1][1] >= intervals[i][0]:
                # merge
                res[-1][1] = max(res[-1][1], intervals[i][1])
            else:
                res.append(intervals[i])
        return res