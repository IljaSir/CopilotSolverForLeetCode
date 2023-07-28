class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] = 1 - grid[i][j]
        for j in range(n):
            cnt = 0
            for i in range(m):
                if grid[i][j] == 1:
                    cnt += 1
            if cnt < (m + 1) // 2:
                for i in range(m):
                    grid[i][j] = 1 - grid[i][j]
        res = 0
        for i in range(m):
            for j in range(n):
                res += grid[i][j] * (1 << (n - j - 1))
        return res