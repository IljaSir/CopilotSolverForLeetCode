class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        
        n = len(graph)
        queue = collections.deque([(i, 1 << i) for i in range(n)])
        visited = {(i, 1 << i): 0 for i in range(n)}
        while queue:
            node, mask = queue.popleft()
            if mask == (1 << n) - 1:
                return visited[(node, mask)]
            for nei in graph[node]:
                mask2 = mask | (1 << nei)
                if (nei, mask2) not in visited:
                    visited[(nei, mask2)] = visited[(node, mask)] + 1
                    queue.append((nei, mask2))