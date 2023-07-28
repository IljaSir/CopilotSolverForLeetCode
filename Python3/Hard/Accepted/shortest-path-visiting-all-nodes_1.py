class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        
        n = len(graph)
        queue = [(i, 1 << i, 0) for i in range(n)]
        seen = {(i, 1 << i) for i in range(n)}
        while queue:
            node, mask, dist = queue.pop(0)
            if mask == (1 << n) - 1:
                return dist
            for nei in graph[node]:
                nmask = mask | (1 << nei)
                if (nei, nmask) not in seen:
                    seen.add((nei, nmask))
                    queue.append((nei, nmask, dist + 1))