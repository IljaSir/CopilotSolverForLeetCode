class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        
        # build graph
        graph = collections.defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # bfs
        visited = set()
        queue = collections.deque([source])
        while queue:
            node = queue.popleft()
            if node == destination:
                return True
            if node in visited:
                continue
            visited.add(node)
            for nei in graph[node]:
                queue.append(nei)
        return False