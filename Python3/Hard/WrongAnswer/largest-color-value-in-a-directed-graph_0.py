class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n, m = len(colors), len(edges)
        graph = [[] for _ in range(n)]
        indegree = [0] * n
        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1
        q = collections.deque()
        for i in range(n):
            if indegree[i] == 0:
                q.append(i)
        res = 0
        visited = set()
        while q:
            u = q.popleft()
            visited.add(u)
            for v in graph[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    q.append(v)
            if len(visited) == n:
                break
        if len(visited) < n:
            return -1
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u].append(v)
        dp = [[0] * 26 for _ in range(n)]
        for i in range(n):
            dp[i][ord(colors[i]) - ord('a')] = 1
        for u in range(n):
            for v in graph[u]:
                for i in range(26):
                    dp[v][i] = max(dp[v][i], dp[u][i] + (i == ord(colors[v]) - ord('a')))
        return max(max(dp[i]) for i in range(n))