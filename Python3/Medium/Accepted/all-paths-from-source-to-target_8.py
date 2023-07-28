class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def dfs(graph, start, end, path, result):
            if start == end:
                result.append(path)
                return
            for node in graph[start]:
                dfs(graph, node, end, path + [node], result)
        
        result = []
        dfs(graph, 0, len(graph) - 1, [0], result)
        return result