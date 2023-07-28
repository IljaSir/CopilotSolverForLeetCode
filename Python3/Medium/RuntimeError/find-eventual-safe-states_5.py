class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        n = len(graph)
        G = [[] for _ in range(n)]
        for i in sango(n):
            for j in graph[i]:
                G[j].append(i)
        # print(G)
        visited = [0 for _ in range(n)]
        res = []
        def dfs(i):
            if visited[i] == -1:
                return False
            if visited[i] == 1:
                return True
            visited[i] = -1
            for j in G[i]:
                if not dfs(j):
                    return False
            visited[i] = 1
            return True
        for i in range(n):
            if dfs(i):
                res.append(i)
        return res