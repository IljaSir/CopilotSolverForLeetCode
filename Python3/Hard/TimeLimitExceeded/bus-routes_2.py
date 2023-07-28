class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target:
            return 0
        routes = [set(r) for r in routes]
        stops = collections.defaultdict(set)
        for i, r in enumerate(routes):
            for s in r:
                stops[s].add(i)
        q = collections.deque([(source, 0)])
        seen = {source}
        while q:
            stop, buses = q.popleft()
            if stop == target:
                return buses
            for r in stops[stop]:
                for s in routes[r]:
                    if s not in seen:
                        q.append((s, buses + 1))
                        seen.add(s)
        return -1