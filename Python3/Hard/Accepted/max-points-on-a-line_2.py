class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) <= 2:
            return len(points)
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        def slope(p1, p2):
            x1, y1 = p1
            x2, y2 = p2
            dy = y2 - y1
            dx = x2 - x1
            if dy == 0:
                return 0, 1
            if dx == 0:
                return 1, 0
            g = gcd(dy, dx)
            return dy // g, dx // g
        res = 0
        for i in range(len(points)):
            slope_dict = {}
            same_point = 1
            for j in range(i + 1, len(points)):
                if points[i] == points[j]:
                    same_point += 1
                    continue
                s = slope(points[i], points[j])
                if s in slope_dict:
                    slope_dict[s] += 1
                else:
                    slope_dict[s] = 2
            res = max(res, same_point, max(slope_dict.values(), default=0))
        return res