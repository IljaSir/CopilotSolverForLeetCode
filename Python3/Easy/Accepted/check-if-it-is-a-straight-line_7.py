class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        if len(coordinates) == 2:
            return True
        A = coordinates[0]
        B = coordinates[1]
        for i in range(2, len(coordinates)):
            C = coordinates[i]
            if (B[0] - A[0]) * (C[1] - A[1]) != (C[0] - A[0]) * (B[1] - A[1]):
                return False
        return True