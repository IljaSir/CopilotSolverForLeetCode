class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                if matrix[i][j] > n:
                    return False
        for i in range(n):
            for j in range(n):
                if matrix[i][j] != matrix[j][i]:
                    return False
        for i in range(n):
            if sorted(matrix[i]) != list(range(1, n+1)):
                return False
        for j in range(n):
            if sorted([matrix[i][j] for i in range(n)]) != list(range(1, n+1)):
                return False
        return True