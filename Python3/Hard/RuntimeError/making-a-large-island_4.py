class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        def dfs(i, j, index):
            if 0 <= i < n and 0 <= j < n and grid[i][j] == 1:
                grid[i][j] = index
                area[index] += 1
                return 1 + dfs(i+1, j, index) + dfs(i-1, j, index) + dfs(i, j+1, index) + dfs(i, j-1, index)
            return 0
        
        n = len(grid)
        area = [0]
        index = 2
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    area.append(dfs(i, j, index))
                    index += 1
        
        res = max(area)
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    seen = set()
                    for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                        if 0 <= x < n and 0 <= y < n:
                            seen.add(grid[x][y])
                    res = max(res, 1 + sum(area[idx] for idx in seen))
        return res