class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        def get_distance(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
        res = 0
        for p in points:
            dist_map = {}
            for q in points:
                if p == q:
                    continue
                dist = get_distance(p, q)
                if dist in dist_map:
                    dist_map[dist] += 1
                else:
                    dist_map[dist] = 1
            for dist in dist_map:
                res += dist_map[dist] * (dist_map[dist] - 1)
        return res