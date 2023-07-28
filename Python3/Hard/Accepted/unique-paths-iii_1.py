class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        start, end, empty = None, None, 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    start = (i, j)
                elif grid[i][j] == 2:
                    end = (i, j)
                elif grid[i][j] == 0:
                    empty += 1
        def dfs(x, y, empty):
            if not (0 <= x < m and 0 <= y < n and grid[x][y] >= 0):
                return 0
            if (x, y) == end:
                return int(empty == -1)
            grid[x][y] = -2
            res = dfs(x + 1, y, empty - 1) + dfs(x - 1, y, empty - 1) + dfs(x, y + 1, empty - 1) + dfs(x, y - 1, empty - 1)
            grid[x][y] = 0
            return res
        return dfs(*start, empty)