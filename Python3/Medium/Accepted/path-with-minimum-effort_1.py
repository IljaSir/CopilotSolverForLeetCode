class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        m, n = len(heights), len(heights[0])
        def bfs(limit):
            visited = [[0] * n for _ in range(m)]
            q = [(0, 0)]
            while q:
                x, y = q.pop(0)
                if x == m - 1 and y == n - 1:
                    return True
                for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and abs(heights[nx][ny] - heights[x][y]) <= limit:
                        visited[nx][ny] = 1
                        q.append((nx, ny))
            return False
        l, r = 0, 10**6
        while l < r:
            mid = (l + r) >> 1
            if bfs(mid):
                r = mid
            else:
                l = mid + 1
        return l