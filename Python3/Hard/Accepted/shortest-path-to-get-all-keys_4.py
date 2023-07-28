class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        start = None
        keys = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                elif grid[i][j].islower():
                    keys.add(grid[i][j])
        visited = set()
        q = [(start, 0, set())]
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while q:
            pos, step, k = q.pop(0)
            if k == keys:
                return step
            if (pos, frozenset(k)) in visited:
                continue
            visited.add((pos, frozenset(k)))
            for dx, dy in dirs:
                x, y = pos
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != '#':
                    if grid[nx][ny].isupper() and grid[nx][ny].lower() not in k:
                        continue
                    if grid[nx][ny].islower() and grid[nx][ny] not in k:
                        nk = set(k)
                        nk.add(grid[nx][ny])
                        q.append(((nx, ny), step + 1, nk))
                    else:
                        q.append(((nx, ny), step + 1, k))
        return -1