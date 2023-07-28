class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        start = None
        keys = set()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                elif grid[i][j].islower():
                    keys.add(grid[i][j])
        def neighbors(i, j):
            for x, y in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)):
                if 0 <= x < m and 0 <= y < n and grid[x][y] != '#':
                    yield x, y
        def is_key(c):
            return c.islower()
        def is_lock(c):
            return c.isupper()
        def is_door(c, keys):
            return c.isupper() and c.lower() not in keys
        def is_empty(c):
            return c == '.'
        def is_start(c):
            return c == '@'
        def is_wall(c):
            return c == '#'
        def is_valid(c, keys):
            return is_empty(c) or is_key(c) or is_start(c) or is_lock(c) and c.lower() in keys
        def bfs(start, end):
            queue = collections.deque([(start, 0)])
            visited = {start}
            while queue:
                (i, j), dist = queue.popleft()
                if (i, j) == end:
                    return dist
                for x, y in neighbors(i, j):
                    if (x, y) in visited:
                        continue
                    visited.add((x, y))
                    if is_valid(grid[x][y], keys):
                        queue.append(((x, y), dist+1))
            return -1
        def dfs(i, j, keys, dist):
            if len(keys) == len(set(grid[i][j] for i in range(m) for j in range(n) if grid[i][j].islower())):
                return dist
            res = float('inf')
            for x, y in neighbors(i, j):
                if is_valid(grid[x][y], keys):
                    if is_key(grid[x][y]):
                        keys.add(grid[x][y])
                    res = min(res, dfs(x, y, keys, dist+1))
                    if is_key(grid[x][y]):