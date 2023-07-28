class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        n = len(graph)
        colors = [0] * n
        for i in range(n):
            if colors[i] == 0:
                colors[i] = 1
                stack = [i]
                while stack:
                    node = stack.pop()
                    for nei in graph[node]:
                        if colors[nei] == 0:
                            colors[nei] = -colors[node]
                            stack.append(nei)
                        elif colors[nei] == colors[node]:
                            return False
        return True