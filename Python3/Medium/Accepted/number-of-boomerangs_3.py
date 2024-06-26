class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def dist(p1, p2):
            return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2
        res = 0
        for p in points:
            d = {}
            for q in points:
                d[dist(p, q)] = d.get(dist(p, q), 0) + 1
            for k in d:
                res += d[k] * (d[k] - 1)
        return res