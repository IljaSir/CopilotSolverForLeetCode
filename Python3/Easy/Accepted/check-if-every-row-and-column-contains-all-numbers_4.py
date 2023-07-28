class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            row = set(matrix[i])
            if len(row) != n:
                return False
            col = set([matrix[j][i] for j in range(n)])
            if len(col) != n:
                return False
        return True