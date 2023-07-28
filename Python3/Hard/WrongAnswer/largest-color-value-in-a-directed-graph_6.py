class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        g = [[] for _ in range(n)]
        for u, v in edges:
            g[u].append(v)
        dp = [[0] * 26 for _ in range(n)]
        # dp[i][j] = the longest path starting from i and color j
        visited = [0] * n
        # 0: not visited; 1: visiting; 2: visited
        def dfs(i):
            if visited[i] == 1:
                return -1
            if visited[i] == 2:
                return max(dp[i])
            visited[i] = 1
            for j in g[i]:
                res = dfs(j)
                if res == -1:
                    return -1
                for k in range(26):
                    dp[i][k] = max(dp[i][k], dp[j][k])
            visited[i] = 2
            dp[i][ord(colors[i]) - ord('a')] += 1
            return max(dp[i])
        res = 0
        for i in range(n):
            res = max(res, dfs(i))
        return res