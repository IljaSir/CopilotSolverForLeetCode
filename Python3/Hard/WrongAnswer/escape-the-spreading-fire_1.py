class Solution:
    def maximumMinutes(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        fire = [[float('inf') for _ in range(n)] for _ in range(m)]
        fire[0][0] = 0
        q = [(0, 0)]
        while q:
            x, y = q.pop(0)
            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                nx, ny = x+dx, y+dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != 2 and fire[nx][ny] == float('inf'):
                    fire[nx][ny] = fire[x][y] + 1
                    q.append((nx, ny))
        if fire[-1][-1] == float('inf'):
            return -1
        if grid[-1][-1] == 1:
            return fire[-1][-1] + 1
        return fire[-1][-1]