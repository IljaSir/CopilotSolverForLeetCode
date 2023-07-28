class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        n = len(mat)
        def rotate(mat):
            new_mat = [[0]*n for _ in range(n)]
            for i in range(n):
                for j in range(n):
                    new_mat[j][n-1-i] = mat[i][j]
            return new_mat
        for _ in range(4):
            mat = rotate(mat)
            if mat == target:
                return True
        return False