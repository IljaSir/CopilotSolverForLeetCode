class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        # build graph
        graph = [[] for _ in range(n)]
        for a, b in dislikes:
            graph[a-1].append(b-1)
            graph[b-1].append(a-1)
        
        # BFS
        colors = [0 for _ in range(n)]
        for i in range(n):
            if colors[i] == 0:
                colors[i] = 1
                queue = [i]
                while queue:
                    node = queue.pop(0)
                    for neighbor in graph[node]:
                        if colors[neighbor] == colors[node]:
                            return False
                        if colors[neighbor] == 0:
                            colors[neighbor] = -colors[node]
                            queue.append(neighbor)
        return True