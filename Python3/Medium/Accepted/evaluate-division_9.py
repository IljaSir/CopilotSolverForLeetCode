class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        def dfs(curr, end, visited):
            if curr == end:
                return 1
            for next, val in graph[curr]:
                if next not in visited:
                    visited.add(next)
                    res = dfs(next, end, visited)
                    if res != -1:
                        return res * val
            return -1
        graph = collections.defaultdict(list)
        for (a, b), v in zip(equations, values):
            graph[a].append((b, v))
            graph[b].append((a, 1 / v))
        return [dfs(a, b, set()) if a in graph and b in graph else -1 for a, b in queries]