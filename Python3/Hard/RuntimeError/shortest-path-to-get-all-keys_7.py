class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        keys = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                elif grid[i][j] in string.ascii_lowercase:
                    keys.add(grid[i][j])
        keys = tuple(sorted(keys))
        def get_neighbors(x, y, keys):
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                xx, yy = x + dx, y + dy
                if 0 <= xx < m and 0 <= yy < n and grid[xx][yy] != '#':
                    if grid[xx][yy] in string.ascii_uppercase and grid[xx][yy].lower() not in keys:
                        continue
                    if grid[xx][yy] in string.ascii_lowercase and grid[xx][yy] not in keys:
                        yield (xx, yy), keys + (grid[xx][yy],)
                    else:
                        yield (xx, yy), keys
        q = deque([(start, tuple())])
        visited = set()
        visited.add((start, tuple()))
        step = 0
        while q:
            size = len(q)
            for _ in range(size):
                x, y = q.popleft()
                for neighbor, new_keys in get_neighbors(x, y, keys):
                    if new_keys == keys:
                        return step + 1
                    if (neighbor, new_keys) not in visited:
                        visited.add((neighbor, new_keys))
                        q.append((neighbor, new_keys))
            step += 1
        return -1