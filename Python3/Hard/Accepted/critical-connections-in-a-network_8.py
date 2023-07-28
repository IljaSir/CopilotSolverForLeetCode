class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        # build graph
        graph = [[] for _ in range(n)]
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        
        # low link
        low = [-1] * n
        # discovery time
        disc = [-1] * n
        # parent
        parent = [-1] * n
        
        # time
        t = 0
        # result
        res = []
        
        def dfs(u):
            nonlocal t
            low[u] = disc[u] = t
            t += 1
            for v in graph[u]:
                if disc[v] == -1:
                    parent[v] = u
                    dfs(v)
                    low[u] = min(low[u], low[v])
                    if low[v] > disc[u]:
                        res.append([u, v])
                elif v != parent[u]:
                    low[u] = min(low[u], disc[v])
        
        dfs(0)
        return res