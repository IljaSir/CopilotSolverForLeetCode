class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        
        # 1. find all the critical points
        # 2. for each critical point, find the highest building
        # 3. if the height is different from the last height, add it to the result
        # 4. return the result
        critical_points = set()
        for building in buildings:
            critical_points.add(building[0])
            critical_points.add(building[1])
        critical_points = sorted(critical_points)
        result = []
        for critical_point in critical_points:
            height = 0
            for building in buildings:
                if building[0] <= critical_point and critical_point < building[1]:
                    height = max(height, building[2])
            if not result or height != result[-1][1]:
                result.append([critical_point, height])
        return result