class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        
        d = {}
        for i in range(len(intervals)):
            d[intervals[i][0]] = i
        intervals.sort()
        ans = []
        for i in range(len(intervals)):
            index = d.get(intervals[i][1], -1)
            if index == -1:
                ans.append(-1)
            else:
                ans.append(index)
        return ans