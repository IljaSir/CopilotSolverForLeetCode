class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                if matrix[i][j] > n:
                    return False
        row = [0] * n
        col = [0] * n
        for i in range(n):
            for j in range(n):
                if matrix[i][j] == 0:
                    return False
                row[i] |= 1 << matrix[i][j]
                col[j] |= 1 << matrix[i][j]
        for i in range(n):
            if row[i] != (1 << n) - 1 or col[i] != (1 << n) - 1:
                return False
        return True