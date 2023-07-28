class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        
        def dis(a, b):
            return (a[0]-b[0])**2+(a[1]-b[1])**2
        a = dis(p1, p2)
        b = dis(p1, p3)
        c = dis(p1, p4)
        if a == 0 or b == 0 or c == 0:
            return False
        if a == b == c:
            return dis(p2, p4) == dis(p3, p4) == a
        if a == b:
            return dis(p2, p4) == dis(p3, p2) == a
        if b == c:
            return dis(p2, p3) == dis(p3, p4) == b
        if a == c:
            return dis(p2, p3) == dis(p2, p4) == a
        return False