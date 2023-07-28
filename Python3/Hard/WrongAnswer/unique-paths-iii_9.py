class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        m = len(grid[0])
        def dfs(x, y, left):
            if not (0 <= x < n and 0 <= y < m) or grid[x][y] < 0:
                return 0
            if grid[x][y] == 2:
                return int(left == 0)
            grid[x][y] = -2
            ans = dfs(x + 1, y, left - 1) + dfs(x - 1, y, left - 1) + dfs(x, y + 1, left - 1) + dfs(x, y - 1, left - 1)
            grid[x][y] = 0
            return ans
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    return dfs(i, j, n * m - sum(row.count(-1) for row in grid))