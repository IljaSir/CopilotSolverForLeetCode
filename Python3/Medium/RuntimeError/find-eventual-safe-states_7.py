class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        
de  eventualSafeNodes(self, g aph: List[List[int]]) -> List[int]:
        fr      if onStack[j] or not visited[j] and dfs(j, graph, visited, onStack):
                    return True
            onStack[i] = False
            return False
        n = len(graph)
        visited = [False] * n
        onStack = [False] * n
        for i in range(n):
            dfs(i, graph, visited, onStack)
        return [i for i in range(n) if not visited[i]]