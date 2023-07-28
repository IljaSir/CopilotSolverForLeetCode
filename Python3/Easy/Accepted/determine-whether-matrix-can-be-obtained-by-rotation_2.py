class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        def rotate(mat):
            n = len(mat)
            return [[mat[n-j-1][i] for j in range(n)] for i in range(n)]
        for _ in range(4):
            if mat == target:
                return True
            mat = rotate(mat)
        return False