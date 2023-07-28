class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 2:
            return True
        if coordinates[1][0] - coordinates[0][0] == 0:
            return all(coordinates[i][0] - coordinates[i-1][0] == 0 for i in range(2, len(coordinates)))
        else:
            slope = (coordinates[1][1] - coordinates[0][1])/(coordinates[1][0] - coordinates[0][0])
            return all((coordinates[i][1] - coordinates[i-1][1])/(coordinates[i][0] - coordinates[i-1][0]) == slope for i in range(2, len(coordinates)))