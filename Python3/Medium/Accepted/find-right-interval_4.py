class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        n = len(intervals)
        start = sorted((e[0], i) for i, e in enumerate(intervals))
        res = []
        for e in intervals:
            i = bisect.bisect_left(start, (e[1],))
            res.append(start[i][1] if i < n else -1)
        return res