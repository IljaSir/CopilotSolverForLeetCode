class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
            
        visited = set()
        stack = [source]
        while stack:
            node = stack.pop()
            if node == destination:
                return True
            visited.add(node)
            for nei in graph[node]:
                if nei not in visited:
                    stack.append(nei)
        return False