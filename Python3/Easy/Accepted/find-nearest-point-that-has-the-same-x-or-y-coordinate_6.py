class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_index = -1
        for i, (px, py) in enumerate(points):
            if px == x or py == y:
                d = abs(x - px) + abs(y - py)
                if d < min_dist:
                    min_dist = d
                    min_index = i
        return min_index