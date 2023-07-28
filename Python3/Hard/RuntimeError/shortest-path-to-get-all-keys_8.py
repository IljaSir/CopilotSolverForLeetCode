class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        key_count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                elif grid[i][j] in string.ascii_lowercase:
                    key_count += 1
        q = collections.deque([(start, 0, 0)])
        seen = set()
        while q:
            (x, y), steps, keys = q.popleft()
            if (x, y, keys) in seen:
                continue
            seen.add((x, y, keys))
            if keys == 2**key_count - 1:
                return steps
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    c = grid[nx][ny]
                    if c == '#':
                        continue
                    if c in string.ascii_lowercase:
                        nkeys = keys | 1 << (ord(c) - ord('a'))
                        q.append(((nx, ny), steps + 1, nkeys))
                    elif c in string.ascii_uppercase:
                        if keys & 1 << (ord(c) - ord('A')):
                            q.append(((nx, ny), steps + 1, keys))
                    else:
                        q.append(((nx, ny), steps + 1, keys))