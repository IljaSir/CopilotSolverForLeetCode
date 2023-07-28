class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def dist(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
        res = 0
        for p1 in points:
            count = collections.Counter(dist(p1, p2) for p2 in points)
            for d in count:
                res += count[d] * (count[d] - 1)
        return res