class Solution:
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        
        def rotate90(mat):
            return [[mat[j][i] for j in range(len(mat))] for i in range(len(mat)-1, -1, -1)]
        for _ in range(4):
            if mat == target:
                return True
            mat = rotate90(mat)
        return False