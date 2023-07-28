class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        visited = [[False]*n for _ in range(m)]
        def dfs(i, j):
            if i < 0 or j < 0 or i >= m or j >= n or visited[i][j] or grid[i][j] == '0':
                return
            visited[i][j] = True
            dfs(i-1, j)
            dfs(i+1, j)
            dfs(i, j-1)
            dfs(i, j+1)
        count = 0
        for i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == '1':
                    dfs(i, j)
                    count += 1
        return count