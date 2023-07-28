class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def dist(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
        res = 0
        for p1 in points:
            d = {}
            for p2 in points:
                d[dist(p1, p2)] = d.get(dist(p1, p2), 0) + 1
            for k in d:
                res += d[k] * (d[k] - 1)
        return res