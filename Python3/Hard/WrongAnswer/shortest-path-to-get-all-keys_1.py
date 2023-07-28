class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                    break
        keys = []
        for i in range(m):
            for j in range(n):
                if grid[i][j].islower():
                    keys.append((i, j))
        k = len(keys)
        if k == 0:
            return 0
        q = [(start, 0, 0)]
        visited = set([(start, 0)])
        while q:
            pos, dist, key = q.pop(0)
            if key == (1 << k) - 1:
                return dist
            for d in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                x, y = pos[0] + d[0], pos[1] + d[1]
                if 0 <= x < m and 0 <= y < n and grid[x][y] != '#':
                    if grid[x][y].isupper():
                        if key & (1 << (ord(grid[x][y]) - ord('A'))) == 0:
                            continue
                    if grid[x][y].islower():
                        key |= (1 << (ord(grid[x][y]) - ord('a')))
                    if (x, y, key) not in visited:
                        q.append(((x, y), dist + 1, key))
                        visited.add((x, y, key))
        return -1