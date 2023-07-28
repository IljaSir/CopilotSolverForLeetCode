class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        def dfs(graph, color, node):
            for i in graph[node]:
                if color[i] == color[node]:
                    return False
                if color[i] == 0:
                    color[i] = -color[node]
                    if not dfs(graph, color, i):
                        return False
            return True
        
        color = [0] * len(graph)
        for i in range(len(graph)):
            if color[i] == 0:
                color[i] = 1
                if not dfs(graph, color, i):
                    return False
        return True