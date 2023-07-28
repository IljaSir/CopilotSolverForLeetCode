class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        n = len(graph)
        res = []
        def dfs(node, path):
            if node == n - 1:
                res.append(path)
            for n in graph[node]:
                dfs(n, path + [n])
        dfs(0, [0])
        return res