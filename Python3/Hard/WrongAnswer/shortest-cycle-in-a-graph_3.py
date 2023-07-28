class Solution:
    def findShortestCycle(self, n: int, edges: List[List[int]]) -> int:
        
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        res = float('inf')
        for u in range(n):
            queue = collections.deque([(u, 0)])
            visited = set([u])
            while queue:
                node, length = queue.popleft()
                for nei in graph[node]:
                    if nei == u:
                        res = min(res, length+1)
                    elif nei not in visited:
                        visited.add(nei)
                        queue.append((nei, length+1))
        return res if res < float('inf') else -1