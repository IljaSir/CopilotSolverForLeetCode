class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def dist(a, b):
            return (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2
        res = 0
        for i in range(len(points)):
            d = {}
            for j in range(len(points)):
                if i == j:
                    continue
                d[dist(points[i], points[j])] = d.get(dist(points[i], points[j]), 0) + 1
            for k in d:
                res += d[k] * (d[k] - 1)
        return res