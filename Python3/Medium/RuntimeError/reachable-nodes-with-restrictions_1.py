class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        
        restricted = set(restricted)
        graph = collections.defaultdict(dict)
        for u, v, w in edges:
            graph[u][v] = graph[v][u] = w
        pq = [(-1, 0)]
        visited = {}
        while pq:
            moves, node = heapq.heappop(pq)
            if node in visited:
                continue
            visited[node] = -moves
            for nei, w in graph[node].items():
                if nei not in visited:
                    heapq.heappush(pq, (moves - w - 1, nei))
        ans = len(visited)
        for u, v, w in edges:
            ans += min(visited.get(u, 0) + visited.get(v, 0), w)
        return ans