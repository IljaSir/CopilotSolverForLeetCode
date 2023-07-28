class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        # graph
        graph = [[] for _ in range(n)]
        for a, b in dislikes:
            graph[a-1].append(b-1)
            graph[b-1].append(a-1)
        # color
        color = [0] * n
        for i in range(n):
            if color[i] == 0:
                color[i] = 1
                stack = [i]
                while stack:
                    node = stack.pop()
                    for nei in graph[node]:
                        if color[nei] == color[node]:
                            return False
                        if color[nei] == 0:
                            color[nei] = -color[node]
                            stack.append(nei)
        return True