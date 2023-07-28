class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        
        def dfs(s, e, visited):
            if s in visited:
                return -1.0
            if s == e:
                return 1.0
            visited.add(s)
            for nei in graph[s]:
                res = dfs(nei, e, visited)
                if res != -1.0:
                    return res * graph[s][nei]
            return -1.0
        
        graph = collections.defaultdict(dict)
        for (s, e), v in zip(equations, values):
            graph[s][e] = v
            graph[e][s] = 1 / v
        res = []
        for s, e in queries:
            if s not in graph or e not in graph:
                res.append(-1.0)
            else:
                res.append(dfs(s, e, set()))
        return res