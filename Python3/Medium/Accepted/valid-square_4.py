class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        p = [p1, p2, p3, p4]
        p.sort()
        def dist(x, y):
            return (x[0]-y[0])**2 + (x[1]-y[1])**2
        return dist(p[0], p[1]) == dist(p[1], p[3]) == dist(p[3], p[2]) == dist(p[2], p[0]) and dist(p[0], p[3]) == dist(p[1], p[2]) and dist(p[0], p[1]) != 0