class Solution:
    def containVirus(self, isInfected: List[List[int]]) -> int:
        
        m, n = len(isInfected), len(isInfected[0])
        def dfs(x, y, visited):
            visited.add((x, y))
            for dx, dy in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited and isInfected[nx][ny] == 1:
                    dfs(nx, ny, visited)
        def bfs(x, y, visited):
            q = collections.deque([(x, y)])
            while q:
                x, y = q.popleft()
                for dx, dy in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited and isInfected[nx][ny] == 1:
                        visited.add((nx, ny))
                        q.append((nx, ny))
        def count(x, y, visited):
            q = collections.deque([(x, y)])
            res = 0
            while q:
                x, y = q.popleft()
                for dx, dy in ((-1, 0), (0, 1), (1, 0), (0, -1)):
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < m and 0 <= ny < n and (nx, ny) not in visited and isInfected[nx][ny] == 0:
                        visited.add((nx, ny))
                        res += 1
                        q.append((nx, ny))
            return res
        res = 0
        while True:
            visited = set()
            max_cnt = 0
            max_x, max_y = -1, -1
            max_visited = set()
            for x in range(m):
                for y in range(n):
                    if isInfected[x][y] == 1 and (x, y) not in visited:
                        visited.add((x, y))
                        cnt = count(x, y, visited)
                        if cnt > max