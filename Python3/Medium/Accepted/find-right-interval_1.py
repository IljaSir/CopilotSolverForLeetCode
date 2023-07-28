class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        starts = [(s, i) for i, (s, e) in enumerate(intervals)]
        starts.sort()
        res = []
        for s, e in intervals:
            i = bisect.bisect_left(starts, (e,))
            res.append(starts[i][1] if i < len(starts) else -1)
        return res