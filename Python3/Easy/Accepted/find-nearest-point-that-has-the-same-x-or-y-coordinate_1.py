class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_idx = -1
        for i, (px, py) in enumerate(points):
            if px == x or py == y:
                dist = abs(px - x) + abs(py - y)
                if dist < min_dist:
                    min_dist = dist
                    min_idx = i
        return min_idx