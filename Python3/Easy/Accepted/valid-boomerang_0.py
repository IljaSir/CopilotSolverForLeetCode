class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        
        
        def get_slope(p1, p2):
            if p1[0] == p2[0]:
                return float('inf')
            return (p1[1] - p2[1]) / (p1[0] - p2[0])
        
        slope1 = get_slope(points[0], points[1])
        slope2 = get_slope(points[1], points[2])
        slope3 = get_slope(points[0], points[2])
        return slope1 != slope2 and slope2 != slope3 and slope1 != slope3