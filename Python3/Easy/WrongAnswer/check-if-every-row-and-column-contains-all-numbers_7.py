class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool:
        
        n = len(matrix)
        for i in range(n):
            for j in range(n):
                if matrix[i][j] > n:
                    return False
        return True