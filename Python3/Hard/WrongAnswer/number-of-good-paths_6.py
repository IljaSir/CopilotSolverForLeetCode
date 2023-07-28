class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        
        from collections import defaultdict
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        self.ans = 0
        def dfs(node, visited, max_val):
            visited.add(node)
            if vals[node] >= max_val:
                max_val = vals[node]
            if node == len(vals) - 1:
                self.ans += 1
                return
            for nei in graph[node]:
                if nei not in visited:
                    dfs(nei, visited, max_val)
        dfs(0, set(), 0)
        return self.ans