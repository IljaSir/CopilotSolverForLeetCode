class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        res = []
        for i in range(len(intervals)):
            r = -1
            for j in range(len(intervals)):
                if i != j and intervals[j][0] >= intervals[i][1]:
                    if r == -1:
                        r = j
                    elif intervals[j][0] < intervals[r][0]:
                        r = j
            res.append(r)
        return res