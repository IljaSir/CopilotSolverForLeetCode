class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                if matrix[i][j] < 1 or matrix[i][j] > n:
                    return False
        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if i != k and matrix[i][j] == matrix[k][j]:
                        return False
                    if j != k and matrix[i][j] == matrix[i][k]:
                        return False
        return True