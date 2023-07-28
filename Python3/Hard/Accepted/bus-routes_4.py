class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target:
            return 0
        routes = [set(route) for route in routes]
        n = len(routes)
        g = [[False] * n for _ in range(n)]
        for i in range(n):
            for j in range(i + 1, n):
                if routes[i] & routes[j]:
                    g[i][j] = g[j][i] = True
        q = collections.deque()
        dist = [-1] * n
        for i, route in enumerate(routes):
            if source in route:
                q.append(i)
                dist[i] = 1
        while q:
            x = q.popleft()
            if target in routes[x]:
                return dist[x]
            for y in range(n):
                if g[x][y] and dist[y] == -1:
                    dist[y] = dist[x] + 1
                    q.append(y)
        return -1