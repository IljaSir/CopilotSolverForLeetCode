class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        q = collections.deque()
        for i in range(n):
            q.append((i, i, 0))
        seen = set()
        while q:
            u, p, d = q.popleft()
            if (u, p) in seen:
                return d
            seen.add((u, p))
            for v in graph[u]:
                if v != p:
                    q.append((v, u, d+1))
        return -1