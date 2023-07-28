class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target: return 0
        from collections import defaultdict
        bus_routes = defaultdict(list)
        for i in range(len(routes)):
            for r in routes[i]:
                bus_routes[r].append(i)
        visited = set()
        cur = [source]
        step = 0
        while cur:
            step += 1
            next = []
            for c in cur:
                for b in bus_routes[c]:
                    if b in visited: continue
                    visited.add(b)
                    for r in routes[b]:
                        if r == target: return step
                        next.append(r)
            cur = next
        return -1