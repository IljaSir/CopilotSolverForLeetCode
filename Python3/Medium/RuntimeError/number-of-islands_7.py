class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        visited = set()
        num_islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (i, j) not in visited and grid[i][j] == '1':
                    num_islands += 1
                    self.dfs(grid, i, j, visited)
        return num_islands