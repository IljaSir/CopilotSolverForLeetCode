class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        self.grid = grid
        self.m = len(grid)
        self.n = len(grid[0])
        self.count = 0
        self.visited = [[False for _ in range(self.n)] for _ in range(self.m)]
        for i in range(self.m):
            for j in range(self.n):
                if self.grid[i][j] == '1' and not self.visited[i][j]:
                    self.bfs(i, j)
                    self.count += 1
        return self.count