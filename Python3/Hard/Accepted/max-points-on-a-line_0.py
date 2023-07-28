class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        def gcd(a, b):
            if b == 0:
                return a
            else:
                return gcd(b, a % b)
        n = len(points)
        ans = 0
        for i in range(n):
            d = {}
            same = 1
            for j in range(i + 1, n):
                x = points[i][0] - points[j][0]
                y = points[i][1] - points[j][1]
                if x == 0 and y == 0:
                    same += 1
                    continue
                g = gcd(x, y)
                x //= g
                y //= g
                d[(x, y)] = d.get((x, y), 0) + 1
            ans = max(ans, max(d.values(), default=0) + same)
        return ans