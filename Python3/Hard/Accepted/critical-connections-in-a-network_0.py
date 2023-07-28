class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = [[] for _ in range(n)]
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        ids = [0] * n
        low = [0] * n
        vis = [0] * n
        self.id = 0
        self.res = []
        def dfs(node, parent):
            self.id += 1
            ids[node] = self.id
            low[node] = self.id
            vis[node] = 1
            for nei in graph[node]:
                if nei == parent:
                    continue
                if vis[nei] == 0:
                    dfs(nei, node)
                    low[node] = min(low[node], low[nei])
                    if low[nei] > ids[node]:
                        self.res.append([node, nei])
                else:
                    low[node] = min(low[node], ids[nei])
        dfs(0, -1)
        return self.res