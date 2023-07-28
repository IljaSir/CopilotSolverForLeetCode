class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        
        def dist(p1, p2):
            return (p1[0] - p2[0])**2 + (p1[1] - p2[1])**2
        
        p = [p1, p2, p3, p4]
        p.sort()
        d = [dist(p[0], p[1]), dist(p[0], p[2]), dist(p[0], p[3]), dist(p[1], p[2]), dist(p[1], p[3]), dist(p[2], p[3])]
        d.sort()
        return d[0] == d[1] == d[2] == d[3] and d[4] == d[5] and d[4] != d[0]