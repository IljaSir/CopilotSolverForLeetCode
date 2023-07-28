class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        n = len(graph)
        color = [0] * n
        for i in range(n):
            if color[i] == 0:
                color[i] = 1
                q = [i]
                while q:
                    u = q.pop()
                    for v in graph[u]:
                        if color[v] == 0:
                            color[v] = -color[u]
                            q.append(v)
                        elif color[v] == color[u]:
                            return False
        return True