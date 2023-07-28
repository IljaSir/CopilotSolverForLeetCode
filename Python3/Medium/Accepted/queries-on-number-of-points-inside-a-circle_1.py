class Solution:
    def countPoints(self, points: List[List[int]], queries: List[List[int]]) -> List[int]:
        
        def is_in_circle(x, y, x0, y0, r):
            return (x - x0)**2 + (y - y0)**2 <= r**2
        return [sum(is_in_circle(x, y, x0, y0, r) for x, y in points) for x0, y0, r in queries]