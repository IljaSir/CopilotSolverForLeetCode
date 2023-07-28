class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def dfs(i, j, idx):
            if 0 <= i < n and 0 <= j < n and grid[i][j] == 1:
                grid[i][j] = idx
                return 1 + dfs(i+1, j, idx) + dfs(i-1, j, idx) + dfs(i, j+1, idx) + dfs(i, j-1, idx)
            return 0
        idx = 2
        area = collections.defaultdict(int)
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area[idx] = dfs(i, j, idx)
                    idx += 1
        ans = max(area.values() or [0])
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = {grid[i+1][j], grid[i-1][j], grid[i][j+1], grid[i][j-1]} - {0}
                    ans = max(ans, 1 + sum(area[idx] for idx in seen))
        return ans