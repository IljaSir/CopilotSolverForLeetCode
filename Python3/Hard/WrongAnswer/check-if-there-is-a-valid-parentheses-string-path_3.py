class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        
        m, n = len(grid), len(grid[0])
        queue = [(0, 0)]
        visited = {(0, 0)}
        while queue:
            x, y = queue.pop(0)
            if x == m - 1 and y == n - 1:
                return True
            for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited:
                    if grid[x][y] == '(' and grid[nx][ny] == ')':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
                    elif grid[x][y] == ')' and grid[nx][ny] == '(':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
                    elif grid[x][y] == '/' and grid[nx][ny] == '\\':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
                    elif grid[x][y] == '\\' and grid[nx][ny] == '/':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
                    elif grid[x][y] == '/' and grid[nx][ny] == '/':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
                    elif grid[x][y] == '\\' and grid[nx][ny] == '\\':
                        queue.append((nx, ny))
                        visited.add((nx, ny))
        return False