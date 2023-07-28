class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        
        total_time = 0
        for i in range(1, len(points)):
            point1 = points[i-1]
            point2 = points[i]
            total_time += max(abs(point1[0] - point2[0]), abs(point1[1] - point2[1]))
        return total_time