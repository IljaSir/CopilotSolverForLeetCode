class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        
        return sum(max(abs(x1 - x0), abs(y1 - y0)) for (x0, y0), (x1, y1) in zip(points, points[1:]))