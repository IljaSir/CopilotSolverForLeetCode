class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        n = len(graph)
        colors = [0] * n
        def dfs(i, color):
            if colors[i] != 0:
                return colors[i] == color
            colors[i] = color
            for j in graph[i]:
                if not dfs(j, -color):
                    return False
            return True
        for i in range(n):
            if colors[i] == 0 and not dfs(i, 1):
                return False
        return True