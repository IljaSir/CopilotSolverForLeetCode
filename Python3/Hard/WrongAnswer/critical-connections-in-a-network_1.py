class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = defaultdict(list)
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        rank = [-2] * n
        def dfs(node, depth):
            if rank[node] >= 0:
                return rank[node]
            rank[node] = depth
            min_back_depth = n
            for nei in graph[node]:
                if rank[nei] == depth - 1:
                    continue
                back_depth = dfs(nei, depth + 1)
                if back_depth <= depth:
                    graph[nei].remove(node)
                    graph[node].remove(nei)
                min_back_depth = min(min_back_depth, back_depth)
            return min_back_depth
        dfs(0, 0)
        return connections