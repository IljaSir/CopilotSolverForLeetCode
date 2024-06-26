class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_dist_idx = -1
        for i, (a, b) in enumerate(points):
            if a == x or b == y:
                dist = abs(x - a) + abs(y - b)
                if dist < min_dist:
                    min_dist = dist
                    min_dist_idx = i
        return min_dist_idx