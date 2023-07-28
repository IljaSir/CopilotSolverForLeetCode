class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) <= 2:
            return len(points)
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        def get_slope(p1, p2):
            x1, y1 = p1
            x2, y2 = p2
            if x1 == x2:
                return (0, 0)
            if y1 == y2:
                return (1, 0)
            dx = x1 - x2
            dy = y1 - y2
            g = gcd(dx, dy)
            dx //= g
            dy //= g
            if dx < 0:
                dx *= -1
                dy *= -1
            return (dx, dy)
        res = 0
        for i in range(len(points)):
            slopes = {}
            for j in range(i):
                slope = get_slope(points[i], points[j])
                slopes[slope] = slopes.get(slope, 0) + 1
            res = max(res, max(slopes.values(), default=0) + 1)
        return res