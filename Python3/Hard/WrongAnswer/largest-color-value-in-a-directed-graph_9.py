class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        G = [[] for _ in range(n)]
        for u, v in edges:
            G[u].append(v)
        color_cnt = collections.defaultdict(int)
        color_cnt[0] = collections.Counter()
        color_cnt[0][colors[0]] = 1
        q = collections.deque([0])
        visited = [0] * n
        while q:
            u = q.popleft()
            visited[u] = 1
            for v in G[u]:
                if visited[v] == 1:
                    return -1
                color_cnt[v] = color_cnt[u] + collections.Counter()
                color_cnt[v][colors[v]] += 1
                q.append(v)
            visited[u] = 2
        return max([max(color_cnt[i].values()) for i in range(n)])