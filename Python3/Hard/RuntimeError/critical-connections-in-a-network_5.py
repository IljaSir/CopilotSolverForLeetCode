class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = {i: [] for i in range(n)}
        for a, b in connections:
            graph[a].append(b)
            graph[b].append(a)
        self.time = 0
        self.low = [0] * n
        self.discovery = [0] * n
        self.result = []
        self.dfs(graph, 0, 0)
        return self.result