class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target:
            return 0
        stops = collections.defaultdict(set)
        for i, route in enumerate(routes):
            for stop in route:
                stops[stop].add(i)
        q = collections.deque([source])
        visited = {source}
        ans = 0
        while q:
            ans += 1
            for _ in range(len(q)):
                stop = q.popleft()
                for bus in stops[stop]:
                    for next_stop in routes[bus]:
                        if next_stop == target:
                            return ans
                        if next_stop not in visited:
                            visited.add(next_stop)
                            q.append(next_stop)
                    routes[bus] = []
        return -1