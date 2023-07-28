class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        
        # 1. get all points
        # 2. sort by distance
        # 3. sort by row
        # 4. sort by col
        # 5. return
        def distance(a, b):
            return abs(a[0] - b[0]) + abs(a[1] - b[1])
        def get_all_points():
            points = []
            for i in range(rows):
                for j in range(cols):
                    points.append((i, j))
            return points
        def sort_by_distance(points):
            return sorted(points, key=lambda x: distance(x, (rStart, cStart)))
        def sort_by_row(points):
            return sorted(points, key=lambda x: x[0])
        def sort_by_col(points):
            return sorted(points, key=lambda x: x[1])
        points = get_all_points()
        points = sort_by_distance(points)
        points = sort_by_row(points)
        points = sort_by_col(points)
        return points