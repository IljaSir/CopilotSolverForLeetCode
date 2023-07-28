class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        def dfs(node, color):
            if node in color:
                return color[node]
            color[node] = 1
            for neighbour in graph[node]:
                if dfs(neighbour, color) == color[node]:
                    return False
                color[neighbour] = -color[node]
            return True
        color = {}
        for node in range(len(graph)):
            if node not in color:
                if not dfs(node, color):
                    return False
        return True