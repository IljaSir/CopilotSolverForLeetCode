class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def dfs(i, path):
            if i == len(graph) - 1:
                res.append(path)
                return
            for j in graph[i]:
                dfs(j, path + [j])
        res = []
        dfs(0, [0])
        return res