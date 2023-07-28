class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0
        m = len(grid)
        n = len(grid[0])
        # print(m, n)
        visited = set()
        def dfs(i, j):
            if (i, j) in visited:
                return
            visited.add((i, j))
            if i > 0 and grid[i-1][j] == '1':
                dfs(i-1, j)
            if j > 0 and grid[i][j-1] == '1':
                dfs(i, j-1)
            if i < m-1 and grid[i+1][j] == '1':
                dfs(i+1, j)
            if j < n-1 and grid[i][j+1] == '1':
                dfs(i, j+1)
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and (i, j) not in visited:
                    dfs(i, j)
                    count += 1
        return count