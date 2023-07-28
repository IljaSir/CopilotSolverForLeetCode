class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
        color = [ord(c) - ord('a') for c in colors]
        visited = [0] * n
        stack = []
        def dfs(node):
            if visited[node] == 1:
                return True
            if visited[node] == 2:
                return False
            visited[node] = 1
            stack.append(node)
            for nei in graph[node]:
                if dfs(nei):
                    return True
            visited[node] = 2
            stack.pop()
            return False
        for i in range(n):
            if dfs(i):
                return -1
        res = 0
        dp = [[0] * 26 for _ in range(n)]
        for node in stack:
            dp[node][color[node]] += 1
            for nei in graph[node]:
                for i in range(26):
                    dp[nei][i] = max(dp[nei][i], dp[node][i])
            res = max(res, max(dp[node]))
        return res