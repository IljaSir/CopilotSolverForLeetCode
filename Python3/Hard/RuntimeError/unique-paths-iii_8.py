class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        self.m = len(grid)
        self.n = len(grid[0])
        self.grid = grid
        self.start, self.end = None, None
        self.empty = 0
        for i in range(self.m):
            for j in range(self.n):
                if grid[i][j] == 0:
                    self.empty += 1
                elif grid[i][j] == 1:
                    self.start = (i, j)
                elif grid[i][j] == 2:
                    self.end = (i, j)
        self.visited = set()
        self.res = 0
        self.dfs(self.start[0], self.start[1])
        return self.res