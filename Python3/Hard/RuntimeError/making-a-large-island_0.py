class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def dfs(i, j, index):
            if 0 <= i < n and 0 <= j < n and grid[i][j] == 1:
                grid[i][j] = index
                return 1 + dfs(i + 1, j, index) + dfs(i - 1, j, index) + dfs(i, j + 1, index) + dfs(i, j - 1, index)
            return 0
        index = 2
        area = {}
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area[index] = dfs(i, j, index)
                    index += 1
        ans = max(area.values() or [0])
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = {grid[x][y] for x, y in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)) if 0 <= x < n and 0 <= y < n}
                    ans = max(ans, 1 + sum(area[i] for i in seen))
        return ans