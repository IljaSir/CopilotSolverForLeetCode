class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        n = len(graph)
        colors = [None] * n
        for i in range(n):
            if colors[i] is None:
                colors[i] = 0
                stack = [i]
                while stack:
                    node = stack.pop()
                    for nei in graph[node]:
                        if colors[nei] is None:
                            colors[nei] = colors[node] ^ 1
                            stack.append(nei)
                        elif colors[nei] == colors[node]:
                            return False
        return True