class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        # check rows
        for row in matrix:
            if sorted(row) != list(range(1, n+1)):
                return False
        # check cols
        for col in range(n):
            if sorted([matrix[row][col] for row in range(n)]) != list(range(1, n+1)):
                return False
        return True