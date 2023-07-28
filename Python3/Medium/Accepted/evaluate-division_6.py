class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        def dfs(n, d, visited):
            if n not in graph or d not in graph:
                return -1.0
            if d in graph[n]:
                return graph[n][d]
            for k in graph[n]:
                if k not in visited:
                    visited.add(k)
                    tmp = dfs(k, d, visited)
                    if tmp != -1.0:
                        return graph[n][k] * tmp
            return -1.0
        graph = collections.defaultdict(dict)
        for (n, d), v in zip(equations, values):
            graph[n][d] = v
            graph[d][n] = 1 / v
        return [dfs(n, d, set()) for n, d in queries]