class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        
        m = len(mat)
        n = len(mat[0])
        if m * n != r * c:
            return mat
        ans = [[0 for _ in range(c)] for _ in range(r)]
        for i in range(m):
            for j in range(n):
                k = i * n + j
                ans[k // c][k % c] = mat[i][j]
        return ans