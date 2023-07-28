class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        
        def dist(x1, y1, x2, y2):
            return (x1 - x2) ** 2 + (y1 - y2) ** 2
        
        points = [p1, p2, p3, p4]
        points.sort()
        p1, p2, p3, p4 = points
        return dist(*p1, *p2) > 0 and dist(*p1, *p2) == dist(*p2, *p3) == dist(*p3, *p4) == dist(*p4, *p1) and dist(*p1, *p3) == dist(*p2, *p4)