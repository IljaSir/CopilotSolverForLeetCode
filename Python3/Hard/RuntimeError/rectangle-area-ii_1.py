class Solution:
    def rectangleArea(self, rectangles: List[List[int]]) -> int:
        
        def area(x1, y1, x2, y2):
            return (x2-x1)*(y2-y1)
        def merge(x1, y1, x2, y2, x3, y3, x4, y4):
            if x1 > x2 or y1 > y2 or x3 > x4 or y3 > y4:
                return (x1, y1, x2, y2, 0)
            x1 = max(x1, x3)
            x2 = min(x2, x4)
            y1 = max(y1, y3)
            y2 = min(y2, y4)
            return (x1, y1, x2, y2, area(x1, y1, x2, y2))
        def intersect(x1, y1, x2, y2, x3, y3, x4, y4):
            return merge(x1, y1, x2, y2, x3, y3, x4, y4)[4]
        def split(x1, y1, x2, y2, x3, y3, x4, y4):
            if x1 > x2 or y1 > y2 or x3 > x4 or y3 > y4:
                return (x1, y1, x2, y2, 0)
            if x1 > x3 or y1 > y3 or x2 < x4 or y2 < y4:
                return (x1, y1, x2, y2, area(x1, y1, x2, y2))
            a = area(x1, y1, x2, y2)
            b = area(x3, y3, x4, y4)
            c = intersect(x1, y1, x2, y2, x3, y3, x4, y4)
            return (x1, y1, x2, y2, a-b+c)
        def solve(x1, y1, x2, y2, rectangles):
            if x1 > x2 or y1 > y2:
                return 0
            if len(rectangles) == 0:
                return area(x1, y1, x2, y2)
            if len(rectangles) ==