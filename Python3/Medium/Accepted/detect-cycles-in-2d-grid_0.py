class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        
        
        def dfs(x, y, d, p, g, v):
            if (x, y) in v:
                return True
            v.add((x, y))
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < len(g) and 0 <= ny < len(g[0]) and (nx, ny) != p and g[nx][ny] == d:
                    if dfs(nx, ny, d, (x, y), g, v):
                        return True
            return False
        
        visited = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if (i, j) not in visited and dfs(i, j, grid[i][j], (-1, -1), grid, visited):
                    return True
        return False