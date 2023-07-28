class Solution:
    def possibleBipartition(self, n: int, dislikes: List[List[int]]) -> bool:
        
        # 1. Build graph
        graph = [[] for _ in range(n + 1)]
        for a, b in dislikes:
            graph[a].append(b)
            graph[b].append(a)
            
        # 2. DFS
        def dfs(node, color):
            if node in color:
                return color[node] == 1
            color[node] = 1
            for nei in graph[node]:
                if not dfs(nei, color):
                    return False
            color[node] = -1
            return True
        
        color = {}
        for i in range(1, n + 1):
            if i not in color and not dfs(i, color):
                return False
        return True