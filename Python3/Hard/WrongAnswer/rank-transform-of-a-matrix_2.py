class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        
        m = len(matrix)
        n = len(matrix[0])
        matrix = [[(matrix[i][j], i, j) for j in range(n)] for i in range(m)]
        for row in matrix:
            row.sort()
        for j in range(n):
            col = [(matrix[i][j][0], i, j) for i in range(m)]
            col.sort()
            for i in range(m):
                matrix[i][j] = col[i]
        rank = [0] * (m + n)
        ans = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j][0] != matrix[i - 1][j][0]:
                    rank[i] = max(rank[i], rank[m + j])
                if matrix[i][j][0] != matrix[i][j - 1][0]:
                    rank[m + j] = max(rank[m + j], rank[i])
                ans[matrix[i][j][1]][matrix[i][j][2]] = rank[i] + 1
                rank[m + j] = rank[i] + 1
        return ans