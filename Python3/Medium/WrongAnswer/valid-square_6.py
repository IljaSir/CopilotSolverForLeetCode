class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        def dist(p1, p2):
            return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2
        def isSquare(p1, p2, p3, p4):
            d1 = dist(p1, p2)
            d2 = dist(p1, p3)
            d3 = dist(p1, p4)
            if d1 == 0 or d2 == 0 or d3 == 0:
                return False
            if d1 == d2 and 2*d1 == d3 and 2*dist(p2, p3) == dist(p2, p4):
                return True
            if d1 == d3 and 2*d1 == d2 and 2*dist(p2, p4) == dist(p2, p3):
                return True
            if d2 == d3 and 2*d2 == d1 and 2*dist(p3, p4) == dist(p3, p2):
                return True
            return False
        return isSquare(p1, p2, p3, p4) or isSquare(p1, p3, p2, p4)