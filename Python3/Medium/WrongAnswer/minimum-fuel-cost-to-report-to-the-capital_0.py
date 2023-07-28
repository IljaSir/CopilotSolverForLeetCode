class Solution:
    def minimumFuelCost(self, roads: List[List[int]], seats: int) -> int:
        
        
        # 1. Build the graph
        graph = defaultdict(list)
        for road in roads:
            graph[road[0]].append(road[1])
            graph[road[1]].append(road[0])
        
        # 2. BFS
        visited = set()
        queue = deque()
        queue.append((0, 0))
        visited.add(0)
        while queue:
            node, cost = queue.popleft()
            for neighbor in graph[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, cost + 1))
        
        # 3. Calculate the cost
        return cost // (seats - 1) + 1 if cost % (seats - 1) else cost // (seats - 1)