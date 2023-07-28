class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source == target:
            return 0
        buses = collections.defaultdict(list)
        for i, route in enumerate(routes):
            for stop in route:
                buses[stop].append(i)
        visited = set()
        queue = collections.deque([(source, 0)])
        while queue:
            stop, cnt = queue.popleft()
            for bus in buses[stop]:
                if bus in visited:
                    continue
                visited.add(bus)
                for next_stop in routes[bus]:
                    if next_stop == target:
                        return cnt + 1
                    queue.append((next_stop, cnt + 1))
        return -1