class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        # build graph
        g = {}
        for (a, b), v in zip(equations, values):
            if a not in g:
                g[a] = {}
            if b not in g:
                g[b] = {}
            g[a][b] = v
            g[b][a] = 1 / v
        # dfs
        def dfs(a, b, visited):
            if a == b:
                return 1
            if a not in g or b not in g:
                return -1
            if b in g[a]:
                return g[a][b]
            for c in g[a]:
                if c in visited:
                    continue
                visited.add(c)
                d = dfs(c, b, visited)
                if d != -1:
                    g[a][b] = g[a][c] * d
                    return g[a][b]
            return -1
        # get answer
        ans = []
        for a, b in queries:
            ans.append(dfs(a, b, set()))
        return ans