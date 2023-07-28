class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = [[] for _ in range(n)]
        for a, b in connections:
            graph[a].append(b)
            graph[b].append(a)
            
        dfn = [0] * n
        low = [0] * n
        res = []
        def dfs(u, parent, step):
            dfn[u] = low[u] = step
            for v in graph[u]:
                if v == parent:
                    continue
                if not dfn[v]:
                    dfs(v, u, step + 1)
                    low[u] = min(low[u], low[v])
                    if low[v] > dfn[u]:
                        res.append([u, v])
                else:
                    low[u] = min(low[u], dfn[v])
        dfs(0, -1, 1)
        return res