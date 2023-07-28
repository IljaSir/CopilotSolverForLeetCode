class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        start = []
        end = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    start = [i, j]
                if grid[i][j] == 2:
                    end = [i, j]
        self.res = 0
        self.dfs(grid, start[0], start[1], end[0], end[1], 0)
        return self.res