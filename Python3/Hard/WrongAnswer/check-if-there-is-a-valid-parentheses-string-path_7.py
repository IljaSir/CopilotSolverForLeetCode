class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m, n = len(grid), len(grid[0])
        if m == 1 and n == 1:
            return True
        # 0: up, 1: right, 2: down, 3: left
        directions = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        visited = [[False] * n for _ in range(m)]
        def dfs(i, j, d):
            if i < 0 or i >= m or j < 0 or j >= n or visited[i][j]:
                return False
            visited[i][j] = True
            if i == m - 1 and j == n - 1:
                return True
            if grid[i][j] == '/':
                if d == 0:
                    return dfs(i, j + 1, 1)
                if d == 1:
                    return dfs(i - 1, j, 0)
                if d == 2:
                    return dfs(i, j - 1, 3)
                if d == 3:
                    return dfs(i + 1, j, 2)
            if grid[i][j] == '\\':
                if d == 0:
                    return dfs(i, j - 1, 3)
                if d == 1:
                    return dfs(i + 1, j, 2)
                if d == 2:
                    return dfs(i, j + 1, 1)
                if d == 3:
                    return dfs(i - 1, j, 0)
            if grid[i][j] == '+':
                for k in range(4):
                    if dfs(i + directions[k][0], j + directions[k][1], k):
                        return True
            if grid[i][j] == '-':
                if d == 1 or d == 3:
                    return dfs(i + directions[d][0], j + directions[d][1], d)
            if grid[i][j] == '|':
                if d == 0 or d == 2:
                    return dfs(i + directions[d][0], j + directions[d][1], d)
            return False
        return dfs(0, 0, 1) or dfs(0, 0, 2)