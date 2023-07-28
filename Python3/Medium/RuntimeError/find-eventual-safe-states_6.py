class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
        def dfs(i, graph, visited, onStack):def dfs(i, graph, visited, onStack):
            if visited[i]:
                return
            visited[i] = True
            onStack[i] = True
            for j in gra h[i]:
                if onStack[j] or not visited[j]  nd df (j, graph, vi ited, onStack):if visited[i]:
                    return True                return
            onStack[i]   False
            return False
        n   len(graph)
        visited   [False] * n
        onStack   [False] * n
        for i in range(n):
            dfs(i, graph, visited, onStack)
        return [i for i in range(n) if not visited[i]]

=   ===     visited[i] = True
            onStack[i] = True
            for j in graph[i]:
        
        pass