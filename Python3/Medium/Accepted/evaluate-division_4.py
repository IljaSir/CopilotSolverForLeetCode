class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        from collections import defaultdict
        graph = defaultdict(dict)
        for (u,v), w in zip(equations, values):
            graph[u][v] = w
            graph[v][u] = 1/w
        
        def dfs(s, t, visited):
            if s not in graph or t not in graph:
                return -1.0
            if t in graph[s]:
                return graph[s][t]
            for v in graph[s]:
                if v not in visited:
                    visited.add(v)
                    tmp = dfs(v, t, visited)
                    if tmp != -1.0:
                        return graph[s][v] * tmp
            return -1.0
        
        res = []
        for s, t in queries:
            res.append(dfs(s, t, set()))
        return res