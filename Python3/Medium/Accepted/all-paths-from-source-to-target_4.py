class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def dfs(node, path):
            if node == n - 1:
                res.append(path)
                return
            for i in graph[node]:
                dfs(i, path + [i])
        
        res = []
        n = len(graph)
        dfs(0, [0])
        return res