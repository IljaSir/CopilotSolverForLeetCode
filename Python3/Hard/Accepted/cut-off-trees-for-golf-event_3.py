class Solution:
    def cutOffTree(self, forest: List[List[int]]) -> int:
        
        m, n = len(forest), len(forest[0])
        trees = sorted([(forest[i][j], i, j) for i in range(m) for j in range(n) if forest[i][j] > 1])
        def bfs(sx, sy, tx, ty):
            q = collections.deque([(sx, sy, 0)])
            seen = {(sx, sy)}
            while q:
                x, y, step = q.popleft()
                if x == tx and y == ty:
                    return step
                for dx, dy in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and forest[nx][ny] and (nx, ny) not in seen:
                        q.append((nx, ny, step + 1))
                        seen.add((nx, ny))
            return -1
        ans = 0
        sx, sy = 0, 0
        for _, tx, ty in trees:
            steps = bfs(sx, sy, tx, ty)
            if steps == -1:
                return -1
            ans += steps
            sx, sy = tx, ty
        return ans