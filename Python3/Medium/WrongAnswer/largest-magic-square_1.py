class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        row = [[0] * (n + 1) for _ in range(m)]
        col = [[0] * (n + 1) for _ in range(m)]
        for i in range(m):
            for j in range(n):
                row[i][j + 1] = row[i][j] + grid[i][j]
                col[i][j + 1] = col[i][j] + grid[i][j]
        res = 1
        for i in range(m):
            for j in range(n):
                for k in range(min(m - i, n - j)):
                    if row[i + k][j + k + 1] - row[i + k][j] == col[i + k][j + k + 1] - col[i + k][j] == col[i][j + k + 1] - col[i][j] == row[i][j + k + 1] - row[i][j]:
                        res = max(res, k + 1)
        return res