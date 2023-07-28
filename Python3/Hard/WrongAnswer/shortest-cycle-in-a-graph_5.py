class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        def bfs(u, v):
            q = collections.deque([(u, 0)])
            visited = {u}
            while q:
                u, dist = q.popleft()
                if u == v:
                    return dist
                for v in graph[u]:
                    if v not in visited:
                        visited.add(v)
                        q.append((v, dist + 1))
            return -1
        res = float('inf')
        for u, v in edges:
            dist = bfs(u, v)
            if dist != -1:
                res = min(res, dist + 1)
        return res if res != float('inf') else -1