class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] = 1 - grid[i][j]
        for j in range(1, n):
            if sum([grid[i][j] for i in range(m)]) < m / 2:
                for i in range(m):
                    grid[i][j] = 1 - grid[i][j]
        return sum([sum([grid[i][j] * 2 ** (n - j - 1) for j in range(n)]) for i in range(m)])