class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        
        m, n = len(grid), len(grid[0])
        start = None
        keys = []
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j)
                if 'a' <= grid[i][j] <= 'f':
                    keys.append((i, j))
        if not keys:
            return 0
        q = collections.deque()
        q.append((start, 0, 0))
        visited = set()
        visited.add((start, 0))
        while q:
            p, k, d = q.popleft()
            if k == (1 << len(keys)) - 1:
                return d
            for i, j in [(p[0] - 1, p[1]), (p[0] + 1, p[1]), (p[0], p[1] - 1), (p[0], p[1] + 1)]:
                if 0 <= i < m and 0 <= j < n and grid[i][j] != '#':
                    if 'A' <= grid[i][j] <= 'F' and k & (1 << (ord(grid[i][j]) - ord('A'))) == 0:
                        continue
                    if 'a' <= grid[i][j] <= 'f':
                        k |= 1 << (ord(grid[i][j]) - ord('a'))
                    if (i, j, k) not in visited:
                        visited.add((i, j, k))
                        q.append(((i, j), k, d + 1))
        return -1