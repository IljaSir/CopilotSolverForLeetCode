class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                if matrix[i][j] not in matrix[i]:
                    return False
                if matrix[i][j] not in [matrix[k][j] for k in range(n)]:
                    return False
        return True