class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def distance(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2

        res = 0
        for p1 in points:
            d = collections.Counter([distance(p1, p2) for p2 in points])
            for k in d:
                res += d[k] * (d[k] - 1)
        return res