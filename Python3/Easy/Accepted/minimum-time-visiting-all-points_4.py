class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        
        def get_distance(point1, point2):
            return max(abs(point1[0] - point2[0]), abs(point1[1] - point2[1]))
        return sum(get_distance(points[i], points[i + 1]) for i in range(len(points) - 1))