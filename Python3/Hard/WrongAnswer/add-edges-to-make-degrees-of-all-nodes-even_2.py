class Solution:
    def isPossible(self, n: int, edges: List[List[int]]) -> bool:
        
        from collections import defaultdict
        adj = defaultdict(list)
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        def dfs(node, parent):
            visited.add(node)
            for nei in adj[node]:
                if nei == parent:
                    continue
                if nei in visited:
                    return False
                if not dfs(nei, node):
                    return False
            return True
        visited = set()
        for i in range(1, n+1):
            if i not in visited:
                if not dfs(i, -1):
                    return False
        if len(edges) % 2 == 0:
            return True
        else:
            return len(edges) == n-1