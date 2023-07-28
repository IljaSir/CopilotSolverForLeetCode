class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        def dist(p1, p2):
            return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2
        def is_right(p1, p2, p3):
            return dist(p1, p2) + dist(p2, p3) == dist(p1, p3)
        def is_square(p1, p2, p3, p4):
            return dist(p1, p2) == dist(p1, p3) == dist(p1, p4) and dist(p2, p3) == dist(p2, p4) and dist(p3, p4) == dist(p2, p3)
        
        return is_square(p1, p2, p3, p4) and is_right(p1, p2, p3)