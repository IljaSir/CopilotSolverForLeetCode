class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for row in matrix:
            if len(set(row)) != n:
                return False
        for j in range(n):
            if len(set([matrix[i][j] for i in range(n)])) != n:
                return False
        return True