class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        # O(n)
        x0, y0 = coordinates[0]
        x1, y1 = coordinates[1]
        for i in range(2, len(coordinates)):
            x, y = coordinates[i]
            if (y1 - y0) * (x1 - x) != (y1 - y) * (x1 - x0):
                return False
        return True