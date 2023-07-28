class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        row = [[0 for _ in range(n+1)] for _ in range(m)]
        col = [[0 for _ in range(n)] for _ in range(m+1)]
        for i in range(m):
            for j in range(n):
                row[i][j+1] = row[i][j] + grid[i][j]
                col[i+1][j] = col[i][j] + grid[i][j]
        def check(k):
            for i in range(m-k+1):
                for j in range(n-k+1):
                    if all(row[i][j:j+k] == [row[i+d][j+d] for d in range(k)] for d in range(k)):
                        if all(row[i+d][j:j+k] == [row[i+d][j+k-d-1] for d in range(k)] for d in range(k)):
                            if all(col[i+d][j] == col[i+k][j+d] for d in range(k)):
                                return True
            return False
        for k in range(min(m,n), 1, -1):
            if check(k):
                return k
        return 1