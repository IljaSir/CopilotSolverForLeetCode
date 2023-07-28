class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        def gcd(a,b):
            if b == 0:
                return a
            return gcd(b, a % b)
        def slope(p1, p2):
            if p1[0] == p2[0]:
                return 0, 0
            dx, dy = p2[0] - p1[0], p2[1] - p1[1]
            g = gcd(dx, dy)
            return dx // g, dy // g
        if len(points) < 3:
            return len(points)
        res = 0
        for i in range(len(points)):
            same = 1
            slopes = collections.defaultdict(int)
            for j in range(i + 1, len(points)):
                if points[i] == points[j]:
                    same += 1
                    continue
                s = slope(points[i], points[j])
                slopes[s] += 1
            if slopes:
                res = max(res, same + max(slopes.values()))
            else:
                res = max(res, same)
        return res