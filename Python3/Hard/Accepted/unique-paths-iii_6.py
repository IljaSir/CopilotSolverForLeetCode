class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        
        def dfs(grid, r, c):
            if not (0 <= r < len(grid) and 0 <= c < len(grid[0]) and grid[r][c] >= 0):
                return 0
            if grid[r][c] == 2:
                return int(self.empty == 0)
            grid[r][c] = -2
            self.empty -= 1
            res = dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1)
            grid[r][c] = 0
            self.empty += 1
            return res

        self.empty = 1
        for r, row in enumerate(grid):
            for c, val in enumerate(row):
                if val == 1:
                    sr, sc = r, c
                elif val == 0:
                    self.empty += 1
        return dfs(grid, sr, sc)