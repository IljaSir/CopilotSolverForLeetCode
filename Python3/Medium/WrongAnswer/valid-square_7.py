class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        def dist(p1,p2):
            return (p1[0]-p2[0])**2+(p1[1]-p2[1])**2
        def isRight(p1,p2,p3):
            return dist(p1,p2)==dist(p2,p3)==dist(p3,p1)
        def isSquare(p1,p2,p3,p4):
            return dist(p1,p2)==dist(p2,p3)==dist(p3,p4)==dist(p4,p1)
        def isRectangle(p1,p2,p3,p4):
            return dist(p1,p2)==dist(p2,p3)==dist(p3,p4)==dist(p4,p1)
        if isRight(p1,p2,p3) and isSquare(p1,p2,p3,p4):
            return True
        if isRight(p1,p2,p4) and isSquare(p1,p2,p4,p3):
            return True
        if isRight(p1,p3,p4) and isSquare(p1,p3,p4,p2):
            return True
        return False