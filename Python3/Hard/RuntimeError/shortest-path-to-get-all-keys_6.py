class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        keys = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    x, y = i, j
                    grid[i][j] = '.'
                if 'a' <= grid[i][j] <= 'f':
                    keys |= 1 << (ord(grid[i][j]) - ord('a'))
        
        def bfs(x, y):
            q = collections.deque([(x, y, 0)])
            seen = {(x, y, 0)}
            steps = 0
            while q:
                for _ in range(len(q)):
                    x, y, cur_keys = q.popleft()
                    if cur_keys == keys:
                        return steps
                    for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0):
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] != '#' and (nx, ny, cur_keys) not in seen:
                            if 'A' <= grid[nx][ny] <= 'F' and cur_keys & (1 << (ord(grid[nx][ny]) - ord('A'))) == 0:
                                continue
                            if 'a' <= grid[nx][ny] <= 'f':
                                cur_keys |= 1 << (ord(grid[nx][ny]) - ord('a'))
                            q.append((nx, ny, cur_keys))
                            seen.add((nx, ny, cur_keys))
                steps += 1
            return -1
        
        return bfs(x, y)