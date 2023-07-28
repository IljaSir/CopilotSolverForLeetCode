class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] = 1 - grid[i][j]
        for j in range(1, n):
            cnt = 0
            for i in range(m):
                cnt += grid[i][j]
            if cnt < m - cnt:
                for i in range(m):
                    grid[i][j] = 1 - grid[i][j]
        res = 0
        for i in range(m):
            for j in range(n):
                res += grid[i][j] * (2 ** (n - j - 1))
        return res