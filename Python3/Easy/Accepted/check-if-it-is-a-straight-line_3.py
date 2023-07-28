class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 2:
            return True
        x0, y0 = coordinates[0]
        x1, y1 = coordinates[1]
        for i in range(2, len(coordinates)):
            x2, y2 = coordinates[i]
            if (x1 - x0)*(y2 - y0) != (x2 - x0)*(y1 - y0):
                return False
        return True