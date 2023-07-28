class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        
        graph = [[] for _ in range(n)]
        for a, b in connections:
            graph[a].append(b)
            graph[b].append(a)
        print(graph)
        def dfs(node, parent):
            if node in visited:
                return visited[node]
            visited[node] = time
            low_time = time
            for neighbor in graph[node]:
                if neighbor == parent:
                    continue
                low_time = min(low_time, dfs(neighbor, node))
            if low_time == visited[node] and parent != -1:
                res.append([node, parent])
            return low_time
        res = []
        visited = {}
        time = 0
        dfs(0, -1)
        return res