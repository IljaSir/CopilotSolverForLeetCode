class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        s = sorted((e, i) for i, (s, e) in enumerate(intervals))
        res = []
        for e, i in intervals:
            idx = bisect.bisect_left(s, (e,))
            res.append(s[idx][1] if idx < len(s) else -1)
        return res