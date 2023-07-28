class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def dfs(i, j, idx):
            if i < 0 or i >= n or j < 0 or j >= n or grid[i][j] != 1:
                return 0
            grid[i][j] = idx
            return 1 + dfs(i + 1, j, idx) + dfs(i - 1, j, idx) + dfs(i, j + 1, idx) + dfs(i, j - 1, idx)
        
        idx = 2
        areas = {0: 0}
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    areas[idx] = dfs(i, j, idx)
                    idx += 1
        ans = max(areas.values())
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = {grid[i + 1][j], grid[i - 1][j], grid[i][j + 1], grid[i][j - 1]}
                    ans = max(ans, 1 + sum(areas[i] for i in seen))
        return ans