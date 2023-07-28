class Solution:
    def outerTrees(self, trees: List[List[int]]) -> List[List[int]]:
        
        def cross(o, a, b):
            return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
        
        def convex_hull(points):
            points = sorted(set(points))
            if len(points) <= 1:
                return points
            hull = []
            for p in points:
                while len(hull) >= 2 and cross(hull[-2], hull[-1], p) < 0:
                    hull.pop()
                hull.append(p)
            hull.pop()
            for p in reversed(points):
                while len(hull) >= 2 and cross(hull[-2], hull[-1], p) < 0:
                    hull.pop()
                hull.append(p)
            return hull
        
        return convex_hull(trees)