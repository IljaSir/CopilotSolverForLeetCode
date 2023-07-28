class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_index = -1
        for i, p in enumerate(points):
            if x == p[0] or y == p[1]:
                dist = abs(x - p[0]) + abs(y - p[1])
                if dist < min_dist:
                    min_dist = dist
                    min_index = i
        return min_index