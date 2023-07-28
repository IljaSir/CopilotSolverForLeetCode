class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        def dfs(a, b, visited):
            if a == b:
                return 1
            visited.add(a)
            for c in graph[a]:
                if c not in visited:
                    tmp = dfs(c, b, visited)
                    if tmp != -1:
                        return tmp * graph[a][c]
            return -1
        graph = collections.defaultdict(dict)
        for (a, b), v in zip(equations, values):
            graph[a][b] = v
            graph[b][a] = 1 / v
        res = []
        for a, b in queries:
            if a not in graph or b not in graph:
                res.append(-1)
            else:
                res.append(dfs(a, b, set()))
        return res