class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        row_sum = [[0 for _ in range(n+1)] for _ in range(m)]
        col_sum = [[0 for _ in range(n)] for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                row_sum[i][j+1] = row_sum[i][j] + grid[i][j]
                col_sum[i+1][j] = col_sum[i][j] + grid[i][j]
        for k in range(min(m, n), 1, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    if all(row_sum[i][j] == row_sum[i][j+k] for i in range(i, i+k)) and all(col_sum[i][j] == col_sum[i+k][j] for j in range(j, j+k)):
                        if all(row_sum[i][j] == col_sum[i][j] for i, j in zip(range(i, i+k), range(j, j+k))):
                            if all(row_sum[i][j+k] - row_sum[i][j] == col_sum[i+k][j] - col_sum[i][j] for i, j in zip(range(i, i+k), range(j, j+k))):
                                return k
        return 1