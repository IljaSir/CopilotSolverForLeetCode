class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        
        
        def find_path(start, end, graph):
            visited = set()
            queue = [start]
            while queue:
                node = queue.pop(0)
                if node == end:
                    return True
                visited.add(node)
                for child in graph[node]:
                    if child not in visited:
                        queue.append(child)
            return False
        
        graph = defaultdict(list)
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])
        return find_path(source, destination, graph)