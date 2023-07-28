class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        def dfs(start, end, visited):
            if start not in graph:
                return -1
            if start == end:
                return 1
            for node, val in graph[start]:
                if node not in visited:
                    visited.add(node)
                    temp = dfs(node, end, visited)
                    if temp != -1:
                        return temp * val
            return -1
        
        graph = collections.defaultdict(list)
        for i in range(len(equations)):
            a, b = equations[i]
            graph[a].append((b, values[i]))
            graph[b].append((a, 1/values[i]))
        res = []
        for a, b in queries:
            res.append(dfs(a, b, set()))
        return res