class Solution:
    def countRectangles(self, rectangles: List[List[int]], points: List[List[int]]) -> List[int]:
        
        def count_rectangles(rectangles, points):
            # Sort points by x value
            points.sort(key=lambda p: p[0])
            # Sort rectangles by x value
            rectangles.sort(key=lambda r: r[0])
            # Initialize count array
            count = [0] * len(points)
            # Initialize rectangle index
            r = 0
            # Iterate through the points
            for p in points:
                # Iterate through the rectangles
                while r < len(rectangles) and rectangles[r][0] <= p[0]:
                    # Check if the rectangle contains the point
                    if rectangles[r][0] <= p[0] and rectangles[r][1] >= p[1]:
                        count[points.index(p)] += 1
                    r += 1
            return count
        return count_rectangles(rectangles, points)