class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        
        n = len(edges)
        g = [[] for _ in range(n)]
        for i, e in enumerate(edges):
            if e != -1:
                g[i].append(e)
        # print(g)
        def dfs(node, visited, stack):
            if visited[node]:
                return -1
            visited[node] = True
            stack[node] = True
            for nei in g[node]:
                if stack[nei]:
                    return nei
                ret = dfs(nei, visited, stack)
                if ret != -1:
                    return ret
            stack[node] = False
            return -1
        visited = [False] * n
        stack = [False] * n
        res = 0
        for i in range(n):
            if visited[i]:
                continue
            ret = dfs(i, visited, stack)
            if ret != -1:
                # print(i, ret)
                s = set()
                while i != ret:
                    s.add(i)
                    i = edges[i]
                s.add(i)
                res = max(res, len(s))
        return res if res > 1 else -1