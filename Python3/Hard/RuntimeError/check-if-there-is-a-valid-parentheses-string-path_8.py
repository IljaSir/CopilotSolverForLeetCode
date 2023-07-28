class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        def check(i, j, path):
            if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]):
                return False
            if grid[i][j] == ' ':
                return False
            if grid[i][j] == '/':
                if path == 0 or path == 1:
                    return False
            if grid[i][j] == '\\':
                if path == 2 or path == 3:
                    return False
            return True
        def dfs(i, j, path):
            if i == len(grid) - 1 and j == len(grid[0]) - 1:
                return True
            grid[i][j] = ' '
            if path == 0:
                return check(i, j - 1, 0) and dfs(i, j - 1, 0) or check(i + 1, j, 3) and dfs(i + 1, j, 3) or check(i - 1, j, 1) and dfs(i - 1, j, 1)
            if path == 1:
                return check(i, j - 1, 0) and dfs(i, j - 1, 0) or check(i, j + 1, 2) and dfs(i, j + 1, 2) or check(i + 1, j, 3) and dfs(i + 1, j, 3)
            if path == 2:
                return check(i, j + 1, 2) and dfs(i, j + 1, 2) or check(i - 1, j, 1) and dfs(i - 1, j, 1) or check(i + 1, j, 3) and dfs(i + 1, j, 3)
            if path == 3:
                return check(i, j - 1, 0) and dfs(i, j - 1, 0) or check(i, j + 1, 2) and dfs(i, j + 1, 2) or check(i - 1, j, 1) and dfs(i - 1, j, 1)
        if grid[0][0] == '/':
            return check(0, 1, 2) and dfs(