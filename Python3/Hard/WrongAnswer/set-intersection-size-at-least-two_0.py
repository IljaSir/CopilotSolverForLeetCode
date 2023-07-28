class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        
        intervals.sort(key=lambda x: x[1])
        res = []
        for interval in intervals:
            if not res or interval[0] > res[-1][1]:
                res.append(interval)
            elif interval[0] > res[-1][0]:
                res[-1] = (res[-1][0], interval[1])
        return len(res)