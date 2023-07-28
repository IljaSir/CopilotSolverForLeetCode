class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m = len(grid)
        n = len(grid[0])
        # 0 = left, 1 = up, 2 = right, 3 = down
        directions = [[(0, -1), (0, 1)], [(-1, 0), (1, 0)], [(0, -1), (0, 1)], [(-1, 0), (1, 0)]]
        map = {'/': [[2, 3], [0, 1]], '\\': [[0, 3], [1, 2]]}
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '/':
                    directions[i][j] = map['/']
                elif grid[i][j] == '\\':
                    directions[i][j] = map['\\']
        def dfs(i, j):
            if i == m - 1 and j == n - 1:
                return True
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == ' ':
                return False
            for d in directions[i][j]:
                grid[i][j] = ' '
                if dfs(i + d[0], j + d[1]):
                    return True
                grid[i][j] = grid[i][j]
            return False
        return dfs(0, 0)