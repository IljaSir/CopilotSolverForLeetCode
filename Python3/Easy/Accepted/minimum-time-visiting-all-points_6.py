class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        
        # # my solution
        # ans = 0
        # for i in range(1, len(points)):
        #     ans += max(abs(points[i][0] - points[i-1][0]), abs(points[i][1] - points[i-1][1]))
        # return ans
        
        # # solution from leetcode
        # return sum(max(abs(points[i][0] - points[i-1][0]), abs(points[i][1] - points[i-1][1])) for i in range(1, len(points)))
        
        # solution from leetcode
        return sum(max(abs(x1 - x0), abs(y1 - y0)) for (x0, y0), (x1, y1) in zip(points, points[1:]))