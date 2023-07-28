class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        n = len(intervals)
        res = [-1] * n
        srt = sorted((e[0], i) for i, e in enumerate(intervals))
        for i, e in enumerate(intervals):
            j = bisect.bisect_left(srt, (e[1],))
            if j < n:
                res[i] = srt[j][1]
        return res