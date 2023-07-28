class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        n = len(graph)
        visited = [0] * n
        def dfs(i):
            if visited[i] == 1:
                return True
            if visited[i] == 2:
                return False
            visited[i] = 2
            for j in graph[i]:
                if not dfs(j):
                    return False
            visited[i] = 1
            return True
        for i in range(n):
            dfs(i)
        return [i for i in range(n) if visited[i] == 1]