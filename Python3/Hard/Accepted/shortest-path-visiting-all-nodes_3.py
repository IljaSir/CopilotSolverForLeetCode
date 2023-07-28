class Solution:
    def shortestPathLength(self, graph: List[List[int]]) -> int:
        
        # 1. BFS
        # 2. bit mask
        # 3. dp
        # 4. 
        N = len(graph)
        queue = collections.deque([(i, 1<<i, 0) for i in range(N)])
        seen = {(i, 1<<i) for i in range(N)}
        while queue:
            node, mask, dist = queue.popleft()
            if mask == (1<<N) - 1:
                return dist
            for nei in graph[node]:
                mask2 = mask | (1<<nei)
                if (nei, mask2) not in seen:
                    seen.add((nei, mask2))
                    queue.append((nei, mask2, dist+1))