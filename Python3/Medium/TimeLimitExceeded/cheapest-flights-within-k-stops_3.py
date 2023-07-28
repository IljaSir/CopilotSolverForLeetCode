class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        d = collections.defaultdict(list)
        for f in flights:
            d[f[0]].append([f[1], f[2]])
        heap = [(0, src, k+1)]
        while heap:
            price, city, k = heapq.heappop(heap)
            if city == dst:
                return price
            if k > 0:
                for c, p in d[city]:
                    heapq.heappush(heap, (price + p, c, k-1))
        return -1