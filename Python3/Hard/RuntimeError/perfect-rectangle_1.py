class Solution:
    def isRectangleCover(self, rectangles: List[List[int]]) -> bool:
        
        total_area = 0
        points = set()
        for x1, y1, x2, y2 in rectangles:
            total_area += (x2 - x1) * (y2 - y1)
            for x, y in [(x1, y1), (x1, y2), (x2, y1), (x2, y2)]:
                if (x, y) in points:
                    points.remove((x, y))
                else:
                    points.add((x, y))
        return total_area == (max(x for x, y in points) - min(x for x, y in points)) * (max(y for x, y in points) - min(y for x, y in points)) and len(points) == 4