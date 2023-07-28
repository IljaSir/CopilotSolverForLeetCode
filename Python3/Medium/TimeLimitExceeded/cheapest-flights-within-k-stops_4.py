class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        # Dijkstra's Algorithm
        graph = collections.defaultdict(list)
        for u, v, w in flights:
            graph[u].append((v, w))
        # (price, city, stops)
        pq = [(0, src, k)]
        while pq:
            price, city, stops = heapq.heappop(pq)
            if city == dst:
                return price
            if stops >= 0:
                for nei, w in graph[city]:
                    heapq.heappush(pq, (price + w, nei, stops - 1))
        return -1