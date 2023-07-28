class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    count += 1
        def dfs(i, j, count):
            if grid[i][j] == 2:
                return count == 0
            grid[i][j] = -1
            count -= 1
            res = 0
            for x, y in [[i+1, j], [i-1, j], [i, j+1], [i, j-1]]:
                if 0 <= x < m and 0 <= y < n and grid[x][y] != -1:
                    res += dfs(x, y, count)
            grid[i][j] = 0
            return res
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return dfs(i, j, count)