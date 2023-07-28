class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        g = [[] for _ in range(n)]
        for u, v in edges:
            g[u].append(v)
        vis = [0] * n
        def dfs(u):
            vis[u] = 1
            for v in g[u]:
                if vis[v] == 1:
                    return True
                if vis[v] == 0 and dfs(v):
                    return True
            vis[u] = 2
            return False
        for i in range(n):
            if vis[i] == 0 and dfs(i):
                return -1
        dp = [[0] * 26 for _ in range(n)]
        for i in range(n):
            dp[i][ord(colors[i]) - ord('a')] = 1
        for i in range(n):
            for j in g[i]:
                for k in range(26):
                    dp[j][k] = max(dp[j][k], dp[i][k] + (k == ord(colors[j]) - ord('a')))
        return max(max(row) for row in dp)