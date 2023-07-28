class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        graph = [[] for _ in range(n+1)]
        for a, b in dislikes:
            graph[a].append(b)
            graph[b].append(a)
        color = [0] * (n+1)
        def dfs(node, c):
            if color[node] != 0:
                return color[node] == c
            color[node] = c
            return all(dfs(nei, -c) for nei in graph[node])
        return all(dfs(i, 1) for i in range(1, n+1) if color[i] == 0)