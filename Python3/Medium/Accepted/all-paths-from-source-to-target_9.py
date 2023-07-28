class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        n = len(graph)
        path = []
        res = []
        def dfs(graph, i):
            path.append(i)
            if i == n - 1:
                res.append(path[:])
            else:
                for j in graph[i]:
                    dfs(graph, j)
            path.pop()
        dfs(graph, 0)
        return res