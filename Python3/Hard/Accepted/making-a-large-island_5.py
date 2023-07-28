class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        def dfs(x, y, index):
            if x < 0 or x >= n or y < 0 or y >= n or grid[x][y] != 1:
                return 0
            grid[x][y] = index
            return 1 + dfs(x + 1, y, index) + dfs(x - 1, y, index) + dfs(x, y + 1, index) + dfs(x, y - 1, index)
        n = len(grid)
        index = 2
        area = collections.defaultdict(int)
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area[index] = dfs(i, j, index)
                    index += 1
        res = max(area.values() or [0])
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    cur = 1
                    seen = set()
                    for x, y in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
                        if 0 <= x < n and 0 <= y < n and grid[x][y] not in seen:
                            seen.add(grid[x][y])
                            cur += area[grid[x][y]]
                    res = max(res, cur)
        return res