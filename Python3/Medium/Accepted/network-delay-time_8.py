class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        
        from collections import defaultdict
        # create a graph
        graph = defaultdict(dict)
        for u, v, w in times:
            graph[u][v] = w
        
        # create a distance table
        distance = {node: float('inf') for node in range(1, n+1)}
        distance[k] = 0
        
        # create a visited table
        visited = set()
        
        # create a priority queue
        import heapq
        pq = [(0, k)]
        
        while pq:
            dist, node = heapq.heappop(pq)
            if node in visited:
                continue
            visited.add(node)
            for nei, nei_dist in graph[node].items():
                if nei not in visited:
                    heapq.heappush(pq, (dist+nei_dist, nei))
                    distance[nei] = min(distance[nei], dist+nei_dist)
        
        return max(distance.values()) if len(visited) == n else -1