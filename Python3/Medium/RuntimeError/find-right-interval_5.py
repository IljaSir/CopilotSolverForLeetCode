class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        start = sorted((e[0],i) for i,e in enumerate(intervals))
        res = []
        for e in intervals:
            r = bisect.bisect_left(start,(e[1]))
            res.append(start[r][1] if r < len(intervals) else -1)
        return res