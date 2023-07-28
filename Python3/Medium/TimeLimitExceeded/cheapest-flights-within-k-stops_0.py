class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        graph = collections.defaultdict(list)
        for u, v, w in flights:
            graph[u].append((v, w))
        pq = [(0, src, k)]
        while pq:
            price, u, k = heapq.heappop(pq)
            if u == dst:
                return price
            if k >= 0:
                for v, w in graph[u]:
                    heapq.heappush(pq, (price + w, v, k - 1))
        return -1