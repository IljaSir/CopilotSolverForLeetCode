class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        if len(graph) == 0:
            return True
        color = {}
        for i in range(len(graph)):
            if i not in color:
                color[i] = 0
                queue = [i]
                while queue:
                    node = queue.pop(0)
                    for neighbor in graph[node]:
                        if neighbor not in color:
                            color[neighbor] = color[node] ^ 1
                            queue.append(neighbor)
                        elif color[neighbor] == color[node]:
                            return False
        return True