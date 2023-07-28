class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        N = len(intervals)
        starts = sorted((s, i) for i, (s, e) in enumerate(intervals))
        res = []
        for e, i in intervals:
            j = bisect.bisect_left(starts, (e, -1))
            res.append(starts[j][1] if j < N else -1)
        return res