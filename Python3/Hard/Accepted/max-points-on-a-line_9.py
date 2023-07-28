class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) == 1:
            return 1
        max_points = 0
        for i in range(len(points)):
            same_point = 0
            point = points[i]
            slope_map = {}
            for j in range(i+1, len(points)):
                point2 = points[j]
                if point[0] == point2[0] and point[1] == point2[1]:
                    same_point += 1
                elif point[0] == point2[0]:
                    slope_map['inf'] = slope_map.get('inf', 0) + 1
                else:
                    slope = (point[1] - point2[1]) / (point[0] - point2[0])
                    slope_map[slope] = slope_map.get(slope, 0) + 1
            max_points = max(max_points, same_point + 1)
            for slope in slope_map:
                max_points = max(max_points, slope_map[slope] + same_point + 1)
        return max_points