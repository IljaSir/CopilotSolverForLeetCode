class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        
        if source==target:
            return 0
        n=len(routes)
        buses=[set() for _ in range(n)]
        busstops=defaultdict(list)
        for i in range(n):
            for stop in routes[i]:
                buses[i].add(stop)
                busstops[stop].append(i)
        q=deque([source])
        visited=set()
        visited.add(source)
        count=0
        while q:
            count+=1
            for _ in range(len(q)):
                stop=q.popleft()
                for bus in busstops[stop]:
                    if target in buses[bus]:
                        return count
                    for next_stop in buses[bus]:
                        if next_stop not in visited:
                            q.append(next_stop)
                            visited.add(next_stop)
        return -1