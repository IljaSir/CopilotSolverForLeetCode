class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        import heapq
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((v, w))
        dist = [float('inf')] * (n + 1)
        dist[k] = 0
        q = [(0, k)]
        while q:
            d, node = heapq.heappop(q)
            if d > dist[node]:
                continue
            for v, w in graph[node]:
                if dist[node] + w < dist[v]:
                    dist[v] = dist[node] + w
                    heapq.heappush(q, (dist[v], v))
        return max(dist[1:]) if max(dist[1:]) < float('inf') else -1