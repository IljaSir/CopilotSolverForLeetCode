class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        # Dijkstra's algorithm, O(ElogV)
        # https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
        from heapq import heappush, heappop
        graph = collections.defaultdict(list)
        for u, v, w in times:
            graph[u].append((v, w))
        dist = {node: float('inf') for node in range(1, n+1)}
        dist[k] = 0
        pq = [(0, k)]
        while pq:
            d, node = heappop(pq)
            if d > dist[node]:
                continue
            for nei, d2 in graph[node]:
                d2 += d
                if d2 < dist[nei]:
                    dist[nei] = d2
                    heappush(pq, (d2, nei))
        ans = max(dist.values())
        return ans if ans < float('inf') else -1