class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        
        def dfs(graph, node, path):
            if node == len(graph) - 1:
                paths.append(path)
                return
            for next_node in graph[node]:
                dfs(graph, next_node, path + [next_node])
        paths = []
        dfs(graph, 0, [0])
        return paths