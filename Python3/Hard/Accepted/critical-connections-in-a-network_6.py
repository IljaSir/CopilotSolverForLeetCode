class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        # build graph
        graph = [[] for _ in range(n)]
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
            
        # dfs
        visited = [False] * n
        low = [0] * n
        pre = [-1] * n
        res = []
        def dfs(u, parent):
            visited[u] = True
            pre[u] = low[u] = pre[parent] + 1
            for v in graph[u]:
                if v == parent:
                    continue
                if not visited[v]:
                    dfs(v, u)
                    low[u] = min(low[u], low[v])
                    if low[v] > pre[u]:
                        res.append([u, v])
                else:
                    low[u] = min(low[u], pre[v])
        dfs(0, 0)
        return res