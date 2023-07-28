class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if (i == 0 or i == m - 1 or j == 0 or j == n - 1) and grid[i][j] == 1:
                    self.dfs(grid, i, j)
        return sum(sum(row) for row in grid)