class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        graph = collections.defaultdict(dict)
        for (x, y), v in zip(equations, values):
            graph[x][y] = v
            graph[y][x] = 1 / v
        def dfs(x, y, visited):
            if x not in graph or y not in graph:
                return -1.0
            if y in graph[x]:
                return graph[x][y]
            for i in graph[x]:
                if i not in visited:
                    visited.add(i)
                    temp = dfs(i, y, visited)
                    if temp != -1.0:
                        return temp * graph[x][i]
            return -1.0
        return [dfs(x, y, set()) for x, y in queries]