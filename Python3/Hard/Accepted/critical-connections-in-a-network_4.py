class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = collections.defaultdict(list)
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        id = [0] * n
        low = [0] * n
        res = []
        def dfs(node, parent, depth):
            if id[node] != 0:
                return
            id[node] = depth
            low[node] = depth
            for child in graph[node]:
                if child == parent:
                    continue
                dfs(child, node, depth + 1)
                low[node] = min(low[node], low[child])
                if low[child] > id[node]:
                    res.append([node, child])
        dfs(0, -1, 1)
        return res