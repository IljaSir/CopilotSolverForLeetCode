class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
        visited = [0] * n
        stack = []
        def dfs(u):
            if visited[u] == 1:
                return False
            if visited[u] == 2:
                return True
            visited[u] = 1
            stack.append(u)
            for v in graph[u]:
                if not dfs(v):
                    return False
            visited[u] = 2
            stack.pop()
            return True
        for u in range(n):
            if not dfs(u):
                return -1
        dp = [[0] * 26 for _ in range(n)]
        for u in stack:
            dp[u][ord(colors[u]) - ord('a')] += 1
            for v in graph[u]:
                for i in range(26):
                    dp[v][i] = max(dp[v][i], dp[u][i])
        return max(max(row) for row in dp)