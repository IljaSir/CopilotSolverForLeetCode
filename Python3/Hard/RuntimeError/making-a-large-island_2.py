class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def dfs(i, j, index):
            if 0 <= i < n and 0 <= j < n and grid[i][j] == 1:
                grid[i][j] = index
                return 1 + dfs(i+1, j, index) + dfs(i-1, j, index) + dfs(i, j+1, index) + dfs(i, j-1, index)
            return 0
        index = 2
        areas = {0:0}
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    areas[index] = dfs(i, j, index)
                    index += 1
        res = max(areas.values())
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    res = max(res, 1+areas.get(grid[i+1][j], 0)+areas.get(grid[i-1][j], 0)+areas.get(grid[i][j+1], 0)+areas.get(grid[i][j-1], 0))
        return res