class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        
        if src == dst:
            return 0
        if k == 0:
            return -1
        k += 1
        adj = defaultdict(list)
        for u, v, w in flights:
            adj[u].append((v, w))
        q = deque([(src, 0)])
        visited = set()
        visited.add(src)
        while q and k:
            k -= 1
            nq = deque()
            while q:
                u, w = q.popleft()
                for v, cost in adj[u]:
                    if v == dst:
                        return w + cost
                    if v not in visited:
                        visited.add(v)
                        nq.append((v, w + cost))
            q = nq
        return -1