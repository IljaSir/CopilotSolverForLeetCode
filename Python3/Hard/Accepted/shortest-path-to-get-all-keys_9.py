class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
        keys = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j].islower():
                    keys += 1
        def get_next(cur):
            x, y, k = cur
            res = []
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != '#':
                    nk = k
                    if grid[nx][ny].islower():
                        nk |= 1 << (ord(grid[nx][ny]) - ord('a'))
                    elif grid[nx][ny].isupper():
                        if not nk & (1 << (ord(grid[nx][ny]) - ord('A'))):
                            continue
                    res.append((nx, ny, nk))
            return res
        q = collections.deque([(start[0], start[1], 0)])
        seen = {(start[0], start[1], 0)}
        step = 0
        while q:
            for _ in range(len(q)):
                x, y, k = q.popleft()
                if k == (1 << keys) - 1:
                    return step
                for nx, ny, nk in get_next((x, y, k)):
                    if (nx, ny, nk) not in seen:
                        q.append((nx, ny, nk))
                        seen.add((nx, ny, nk))
            step += 1
        return -1