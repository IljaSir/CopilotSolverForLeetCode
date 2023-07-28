class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        def dist(x, y, a, b):
            return abs(x - a) + abs(y - b)
        ans = -1
        ans_dist = 10**6
        for i, (a, b) in enumerate(points):
            if x == a or y == b:
                d = dist(x, y, a, b)
                if d < ans_dist:
                    ans_dist = d
                    ans = i
        return ans