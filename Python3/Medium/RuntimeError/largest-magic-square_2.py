class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        row = [[0] * (n + 1) for _ in range(m)]
        col = [[0] * (n + 1) for _ in range(m)]
        for i in range(m):
            for j in range(n):
                row[i][j + 1] = row[i][j] + grid[i][j]
                col[i][j + 1] = col[i][j] + grid[i][j]
        for k in range(min(m, n), 1, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    if all(row[i + x][j + k] - row[i + x][j] == row[i][j + k] - row[i][j] for x in range(k)):
                        if all(col[i + k][j + y] - col[i][j + y] == col[i + k][j] - col[i][j] for y in range(k)):
                            if all(row[i + x][j + k] - row[i + x][j] == col[i + k][j + y] - col[i][j + y] for x, y in [(0, 0), (k - 1, 0), (0, k - 1), (k - 1, k - 1)]):
                                return k
        return 1