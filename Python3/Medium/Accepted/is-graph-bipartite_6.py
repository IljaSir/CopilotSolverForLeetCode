class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        if not graph:
            return True
        n = len(graph)
        color = [0] * n
        for i in range(n):
            if color[i] == 0:
                color[i] = 1
                q = collections.deque([i])
                while q:
                    node = q.popleft()
                    for nei in graph[node]:
                        if color[nei] == color[node]:
                            return False
                        if color[nei] == 0:
                            color[nei] = -color[node]
                            q.append(nei)
        return True