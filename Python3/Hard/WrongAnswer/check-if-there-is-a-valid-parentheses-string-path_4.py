class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m = len(grid)
        n = len(grid[0])
        visited = set()
        def dfs(i, j):
            if i == m - 1 and j == n - 1:
                return True
            visited.add((i, j))
            if i < m - 1 and grid[i][j] in ['/', '\\', '('] and grid[i + 1][j] in ['/', '\\', ')'] and (i + 1, j) not in visited and dfs(i + 1, j):
                return True
            if i > 0 and grid[i][j] in ['/', '\\', ')'] and grid[i - 1][j] in ['/', '\\', '('] and (i - 1, j) not in visited and dfs(i - 1, j):
                return True
            if j < n - 1 and grid[i][j] in ['/', '\\', '('] and grid[i][j + 1] in ['/', '\\', '('] and (i, j + 1) not in visited and dfs(i, j + 1):
                return True
            if j > 0 and grid[i][j] in ['/', '\\', ')'] and grid[i][j - 1] in ['/', '\\', ')'] and (i, j - 1) not in visited and dfs(i, j - 1):
                return True
            return False
        return dfs(0, 0)