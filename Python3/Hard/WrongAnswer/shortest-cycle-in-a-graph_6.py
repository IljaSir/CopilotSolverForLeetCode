class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        # BFS
        def bfs(s):
            q = collections.deque()
            q.append(s)
            dist = [0] * n
            while q:
                u = q.popleft()
                for v in graph[u]:
                    if dist[v] == 0:
                        dist[v] = dist[u] + 1
                        q.append(v)
                    elif dist[v] >= 1 and dist[v] < dist[u] + 1:
                        return dist[u] + 1
            return -1
        
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        res = float('inf')
        for i in range(n):
            res = min(res, bfs(i))
        return res if res != float('inf') else -1