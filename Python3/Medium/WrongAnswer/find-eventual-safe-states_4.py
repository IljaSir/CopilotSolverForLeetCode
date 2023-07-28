class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        n = len(graph)
        G = [[] for _ in range(n)]
        in_deg = [0] * n
        for u, vs in enumerate(graph):
            for v in vs:
                G[v].append(u)
                in_deg[u] += 1
        q = collections.deque([u for u in range(n) if not in_deg[u]])
        res = []
        while q:
            u = q.popleft()
            res.append(u)
            for v in G[u]:
                in_deg[v] -= 1
                if not in_deg[v]:
                    q.append(v)
        return res