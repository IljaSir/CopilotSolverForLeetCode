class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        n = len(graph)
        res = []
        def dfs(path, node):
            if node == n-1:
                res.append(path)
                return
            for next_node in graph[node]:
                dfs(path+[next_node], next_node)
        dfs([0], 0)
        return res