class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        row = [[0] * (n+1) for _ in range(m)]
        col = [[0] * (n) for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                row[i][j+1] = row[i][j] + grid[i][j]
                col[i+1][j] = col[i][j] + grid[i][j]
        for k in range(min(m, n), 1, -1):
            for i in range(m-k+1):
                for j in range(n-k+1):
                    if row[i][j+k] - row[i][j] == col[i+k][j] - col[i][j] == col[i+k][j+k] - col[i][j+k] == row[i+k][j+k] - row[i+k][j]:
                        return k
        return 1