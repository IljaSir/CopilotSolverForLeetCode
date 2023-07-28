class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        starts = sorted((e[0], i) for i, e in enumerate(intervals))
        res = []
        for e in intervals:
            pos = bisect.bisect_left(starts, (e[1],))
            res.append(starts[pos][1] if pos < len(starts) else -1)
        return res