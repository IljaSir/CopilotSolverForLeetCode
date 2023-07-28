class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        MOD = 10**9 + 7
        n = len(vals)
        graph = [[] for _ in range(n)]
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        def dfs(u, p):
            for v in graph[u]:
                if v == p: continue
                dfs(v, u)
                for i in range(n):
                    if vals[u] >= vals[i]:
                        dp[u][i] += dp[v][i]
                        dp[u][i] %= MOD
        dfs(0, -1)
        return sum(dp[0]) % MOD