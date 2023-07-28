class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for row in matrix:
            if sorted(row) != list(range(1, n + 1)):
                return False
        for j in range(n):
            if sorted(matrix[i][j] for i in range(n)) != list(range(1, n + 1)):
                return False
        return True