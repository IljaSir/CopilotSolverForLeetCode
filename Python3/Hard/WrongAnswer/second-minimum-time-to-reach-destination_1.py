class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        
        graph = [[] for _ in range(n)]
        for u, v in edges:
            graph[u-1].append(v-1)
            graph[v-1].append(u-1)
        # bfs
        q = [(0, 0, 0)]
        visited = set()
        while q:
            u, t, c = q.pop(0)
            if u == n-1:
                return t
            if (u, c) in visited:
                continue
            visited.add((u, c))
            for v in graph[u]:
                q.append((v, t + time + (c + time) // change * change - c, (c + time) % change))
        return -1