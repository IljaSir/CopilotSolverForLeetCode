class Solution:
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        
        ans = 0
        for x1, y1 in points:
            d = {}
            for x2, y2 in points:
                dx = x1 - x2
                dy = y1 - y2
                dist = dx * dx + dy * dy
                d[dist] = d.get(dist, 0) + 1
            for k in d:
                ans += d[k] * (d[k] - 1)
        return ans