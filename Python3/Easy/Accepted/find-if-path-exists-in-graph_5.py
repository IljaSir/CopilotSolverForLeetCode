class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        
        # BFS
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        queue = deque([source])
        seen = set([source])
        while queue:
            node = queue.popleft()
            if node == destination:
                return True
            for nei in graph[node]:
                if nei not in seen:
                    seen.add(nei)
                    queue.append(nei)
        return False