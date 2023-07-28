class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        keys = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                elif 'a' <= grid[i][j] <= 'f':
                    keys.add(grid[i][j])
        keys = list(keys)
        k = len(keys)
        if k == 0:
            return 0
        dist = [[-1] * n for _ in range(m)]
        dist[start[0]][start[1]] = 0
        q = deque([start])
        while q:
            x, y = q.popleft()
            for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != '#' and dist[nx][ny] == -1:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))
        dp = [[-1] * (1 << k) for _ in range(m * n)]
        dp[start[0] * n + start[1]][0] = 0
        q = deque([(start[0] * n + start[1], 0)])
        while q:
            s, state = q.popleft()
            x, y = s // n, s % n
            for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != '#':
                    ns = nx * n + ny
                    nstate = state
                    if 'A' <= grid[nx][ny] <= 'F':
                        if not (state >> (ord(grid[nx][ny]) - ord('A')) & 1):
                            continue
                    elif 'a' <= grid[nx][ny] <= 'f':
                        nstate = state | (1 << (ord(grid[nx][ny]) - ord('a')))