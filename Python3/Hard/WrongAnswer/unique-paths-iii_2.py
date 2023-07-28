class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        start = None
        end = None
        empty = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    start = (i, j)
                if grid[i][j] == 2:
                    end = (i, j)
                if grid[i][j] == 0:
                    empty += 1
        def dfs(x, y, empty):
            if grid[x][y] == 2:
                return 1 if empty == 0 else 0
            grid[x][y] = -1
            res = 0
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != -1:
                    res += dfs(nx, ny, empty - 1)
            grid[x][y] = 0
            return res
        return dfs(start[0], start[1], empty)