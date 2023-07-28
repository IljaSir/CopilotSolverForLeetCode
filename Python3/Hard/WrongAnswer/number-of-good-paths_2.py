class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        MOD = 10**9 + 7
        N = len(vals)
        G = collections.defaultdict(list)
        for a, b in edges:
            G[a].append(b)
            G[b].append(a)
        def dfs(node, par, maxval):
            res = int(vals[node] >= maxval)
            maxval = max(maxval, vals[node])
            for nei in G[node]:
                if nei != par:
                    res += dfs(nei, node, maxval)
            return res
        return dfs(0, -1, -1) % MOD