class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        ret = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    ret += 1
                    self.dfs(grid, i, j)
        return ret