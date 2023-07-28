class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = [[] for _ in range(n)]
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        self.ids = [-1] * n
        self.low = [-1] * n
        self.id = 0
        self.res = []
        self.dfs(graph, 0, -1)
        return self.res