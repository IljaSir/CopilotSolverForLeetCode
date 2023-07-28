class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        n = len(edges)
        parent = list(range(n+1))
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        for edge in edges:
            x, y = edge
            if find(x) == find(y):
                return edge
            parent[find(x)] = find(y)