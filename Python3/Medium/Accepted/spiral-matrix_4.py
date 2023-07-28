class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        if not matrix:
            return []
        m, n = len(matrix), len(matrix[0])
        visited = [[False] * n for _ in range(m)]
        res = []
        i, j = 0, 0
        di, dj = 0, 1
        for _ in range(m * n):
            res.append(matrix[i][j])
            visited[i][j] = True
            if not visited[(i + di) % m][(j + dj) % n]:
                i += di
                j += dj
            else:
                di, dj = dj, -di
                i += di
                j += dj
        return res