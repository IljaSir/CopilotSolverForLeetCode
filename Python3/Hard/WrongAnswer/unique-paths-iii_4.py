class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        start = end = None
        empty = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    start = (i, j)
                elif grid[i][j] == 2:
                    end = (i, j)
                elif grid[i][j] == 0:
                    empty += 1
        self.res = 0
        def dfs(i, j, empty):
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] < 0:
                return
            if grid[i][j] == 2:
                if empty == 0:
                    self.res += 1
                return
            grid[i][j] = -2
            dfs(i-1, j, empty-1)
            dfs(i+1, j, empty-1)
            dfs(i, j-1, empty-1)
            dfs(i, j+1, empty-1)
            grid[i][j] = 0
        dfs(start[0], start[1], empty)
        return self.res