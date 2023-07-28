class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        MOD = 10**9 + 7
        n = len(vals)
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        # print(graph)
        
        @lru_cache(None)
        def dfs(node, val):
            if vals[node] < val:
                return 0
            if vals[node] > val:
                val = vals[node]
            if len(graph[node]) == 1:
                return 1
            return sum(dfs(n, val) for n in graph[node]) % MOD
        return sum(dfs(n, 0) for n in graph[0]) % MOD