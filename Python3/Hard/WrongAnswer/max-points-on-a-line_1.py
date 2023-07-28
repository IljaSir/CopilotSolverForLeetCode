class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a
        def get_slope(p1, p2):
            if p1[0] == p2[0]:
                return (0, 0)
            if p1[1] == p2[1]:
                return (1, 0)
            a = p2[0] - p1[0]
            b = p2[1] - p1[1]
            g = gcd(a, b)
            a //= g
            b //= g
            if a < 0:
                a = -a
                b = -b
            return (a, b)
        n = len(points)
        if n < 3:
            return n
        res = 2
        for i in range(n):
            slopes = {}
            same = 1
            for j in range(i + 1, n):
                if points[i] == points[j]:
                    same += 1
                    continue
                slope = get_slope(points[i], points[j])
                if slope in slopes:
                    slopes[slope] += 1
                else:
                    slopes[slope] = 2
            res = max(res, same)
            for s in slopes:
                res = max(res, slopes[s] + same)
        return res