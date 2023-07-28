class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        dp = {}
        def dfs(u, v):
            if (u, v) in dp:
                return dp[(u, v)]
            if vals[u] < vals[v]:
                return 0
            res = 1 if u == v else 0
            for w in graph[v]:
                if w == u:
                    continue
                res += dfs(v, w)
            dp[(u, v)] = res
            return res
        return sum(dfs(u, u) for u in range(len(vals))) % (10**9 + 7)