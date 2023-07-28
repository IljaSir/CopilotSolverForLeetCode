class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        from collections import defaultdict
        graph = defaultdict(list)
        for a, b in edges:
            graph[a].append(b)
        n = len(colors)
        visited = [0]*n
        path = [0]*n
        def dfs(i):
            if visited[i] == 1:
                return True
            if visited[i] == 2:
                return False
            visited[i] = 1
            for j in graph[i]:
                if dfs(j):
                    return True
            visited[i] = 2
            path[i] = 1
            return False
        for i in range(n):
            if dfs(i):
                return -1
        colors = [ord(c)-97 for c in colors]
        dp = [[0]*26 for _ in range(n)]
        for i in range(n):
            dp[i][colors[i]] = 1
        for i in range(n):
            if not path[i]:
                continue
            for j in graph[i]:
                for k in range(26):
                    dp[j][k] = max(dp[j][k], dp[i][k]+(k==colors[j]))
        return max(max(dp[i]) for i in range(n))