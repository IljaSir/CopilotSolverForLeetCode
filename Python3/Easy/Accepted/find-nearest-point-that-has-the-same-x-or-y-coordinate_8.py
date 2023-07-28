class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        
        min_distance = 10**5
        min_index = -1
        for i, (a, b) in enumerate(points):
            if a == x or b == y:
                distance = abs(a - x) + abs(b - y)
                if distance < min_distance:
                    min_distance = distance
                    min_index = i
        return min_index