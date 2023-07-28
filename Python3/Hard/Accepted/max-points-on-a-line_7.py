class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        
        if len(points) < 3:
            return len(points)
        max_points = 0
        for i in range(len(points)):
            same_points = 1
            slopes = {}
            for j in range(i+1, len(points)):
                if points[j][0] == points[i][0] and points[j][1] == points[i][1]:
                    same_points += 1
                elif points[j][0] == points[i][0]:
                    slopes['inf'] = slopes.get('inf', 0) + 1
                else:
                    slope = (points[j][1] - points[i][1]) / (points[j][0] - points[i][0])
                    slopes[slope] = slopes.get(slope, 0) + 1
            if len(slopes) == 0:
                max_points = max(max_points, same_points)
            else:
                max_points = max(max_points, same_points + max(slopes.values()))
        return max_points