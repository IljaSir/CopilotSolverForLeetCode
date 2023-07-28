class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        n = len(equations)
        graph = collections.defaultdict(list)
        for i in range(n):
            graph[equations[i][0]].append((equations[i][1], values[i]))
            graph[equations[i][1]].append((equations[i][0], 1 / values[i]))
        def dfs(a, b, visited):
            if a not in graph or b not in graph:
                return -1
            if a == b:
                return 1
            visited.add(a)
            for c, val in graph[a]:
                if c in visited:
                    continue
                visited.add(c)
                tmp = dfs(c, b, visited)
                if tmp == -1:
                    continue
                return val * tmp
            return -1
        res = []
        for a, b in queries:
            res.append(dfs(a, b, set()))
        return res