class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        
        m, n = len(mat), len(mat[0])
        result = []
        for i in range(m):
            for j in range(n):
                result.append(mat[i][j])
        return result