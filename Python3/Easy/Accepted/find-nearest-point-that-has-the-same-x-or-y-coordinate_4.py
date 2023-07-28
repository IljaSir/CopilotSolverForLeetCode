class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_idx = -1
        for i, (px, py) in enumerate(points):
            if x == px or y == py:
                dist = abs(x - px) + abs(y - py)
                if dist < min_dist:
                    min_dist = dist
                    min_idx = i
        return min_idx