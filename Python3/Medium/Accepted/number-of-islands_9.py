class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        # BFS
        # Time  complexity: O(MN)
        # Space complexity: O(min(M,N))
        def bfs(grid, i, j):
            queue = [(i, j)]
            grid[i][j] = '0'
            while queue:
                i, j = queue.pop()
                for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                    if 0 <= x < len(grid) and 0 <= y < len(grid[0]) and grid[x][y] == '1':
                        grid[x][y] = '0'
                        queue.append((x, y))
        
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    bfs(grid, i, j)
                    res += 1
        return res

        # DFS
        # Time  complexity: O(MN)
        # Space complexity: O(MN)
        def dfs(grid, i, j):
            if not 0 <= i < len(grid) or not 0 <= j < len(grid[0]) or grid[i][j] == '0':
                return
            grid[i][j] = '0'
            dfs(grid, i-1, j)
            dfs(grid, i+1, j)
            dfs(grid, i, j-1)
            dfs(grid, i, j+1)
        
        if not grid or not grid[0]:
            return 0
        m, n = len(grid), len(grid[0])
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    dfs(grid, i, j)
                    res += 1
        return res