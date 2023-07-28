class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        points = [p1, p2, p3, p4]
        points.sort()
        def dist(p1, p2):
            return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2
        return dist(points[0], points[1]) != 0 and \
               dist(points[0], points[1]) == dist(points[1], points[3]) and \
               dist(points[1], points[3]) == dist(points[3], points[2]) and \
               dist(points[3], points[2]) == dist(points[2], points[0]) and \
               dist(points[0], points[3]) == dist(points[1], points[2])