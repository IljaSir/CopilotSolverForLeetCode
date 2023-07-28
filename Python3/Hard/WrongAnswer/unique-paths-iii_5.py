class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        def dfs(x, y, remain):
            if x < 0 or x >= m or y < 0 or y >= n or grid[x][y] == -1:
                return 0
            if grid[x][y] == 2:
                return 1 if remain == 1 else 0
            grid[x][y] = -1
            res = dfs(x + 1, y, remain - 1) + dfs(x - 1, y, remain - 1) + dfs(x, y + 1, remain - 1) + dfs(x, y - 1, remain - 1)
            grid[x][y] = 0
            return res
        m, n = len(grid), len(grid[0])
        start_x, start_y = 0, 0
        remain = 1
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    remain += 1
                elif grid[i][j] == 1:
                    start_x, start_y = i, j
        return dfs(start_x, start_y, remain)