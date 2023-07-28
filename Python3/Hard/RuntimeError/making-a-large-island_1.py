class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def dfs(i, j, index):
            if 0 <= i < n and 0 <= j < n and grid[i][j] == 1:
                grid[i][j] = index
                return 1 + dfs(i+1, j, index) + dfs(i-1, j, index) + dfs(i, j+1, index) + dfs(i, j-1, index)
            return 0
        index = 2
        area = {0:0}
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area[index] = dfs(i, j, index)
                    index += 1
        res = max(area.values())
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = {grid[i+1][j], grid[i-1][j], grid[i][j+1], grid[i][j-1]}
                    res = max(res, 1 + sum(area[i] for i in seen if i > 1))
        return res