class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def distance(x1, y1, x2, y2):
            return (x1 - x2) ** 2 + (y1 - y2) ** 2
        ans = 0
        for i in range(len(points)):
            d = {}
            for j in range(len(points)):
                if i != j:
                    d[distance(points[i][0], points[i][1], points[j][0], points[j][1])] = d.get(distance(points[i][0], points[i][1], points[j][0], points[j][1]), 0) + 1
            for k in d:
                ans += d[k] * (d[k] - 1)
        return ans