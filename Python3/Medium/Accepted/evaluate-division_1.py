class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        graph = collections.defaultdict(list)
        for (x, y), val in zip(equations, values):
            graph[x].append((y, val))
            graph[y].append((x, 1 / val))
        def dfs(x, y, visited):
            if x not in graph or y not in graph:
                return -1.0
            if x == y:
                return 1.0
            visited.add(x)
            for nei, val in graph[x]:
                if nei not in visited:
                    visited.add(nei)
                    new_val = dfs(nei, y, visited)
                    if new_val != -1.0:
                        return new_val * val
            return -1.0
        return [dfs(x, y, set()) for x, y in queries]