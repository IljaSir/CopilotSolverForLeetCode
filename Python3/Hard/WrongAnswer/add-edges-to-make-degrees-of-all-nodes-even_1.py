class Solution:
    def isPossible(self, n: int, edges: List[List[int]]) -> bool:
        
        if len(edges) % 2 == 1:
            return False
        graph = collections.defaultdict(set)
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)
        visited = set()
        def dfs(u):
            visited.add(u)
            for v in graph[u]:
                if v not in visited:
                    dfs(v)
        count = 0
        for u in range(1, n + 1):
            if u not in visited:
                dfs(u)
                count += 1
        return count == 1