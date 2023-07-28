class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_dist = float('inf')
        min_index = -1
        for index, point in enumerate(points):
            if x == point[0] or y == point[1]:
                dist = abs(x - point[0]) + abs(y - point[1])
                if dist < min_dist:
                    min_dist = dist
                    min_index = index
        return min_index