class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        i, j, di, dj = 0, 0, 0, 1
        for k in range(n * n):
            matrix[i][j] = k + 1
            if matrix[(i + di) % n][(j + dj) % n]:
                di, dj = dj, -di
            i += di
            j += dj
        return matrix