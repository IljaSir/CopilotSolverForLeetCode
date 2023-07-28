class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        from collections import defaultdict
        g = defaultdict(list)
        for u, v, w in flights:
            g[u].append((v, w))
        heap = [(0, src, k+1)]
        while heap:
            cost, u, k = heapq.heappop(heap)
            if u == dst:
                return cost
            if k > 0:
                for v, w in g[u]:
                    heapq.heappush(heap, (cost+w, v, k-1))
        return -1