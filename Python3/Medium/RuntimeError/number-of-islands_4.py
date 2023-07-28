class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid: return 0
        m, n = len(grid), len(grid[0])
        visited = [[False for _ in range(n)] for _ in range(m)]
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and not visited[i][j]:
                    self.dfs(grid, i, j, visited)
                    count += 1
        return count