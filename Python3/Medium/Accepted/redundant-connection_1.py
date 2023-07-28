class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        n = len(edges)
        parent = [i for i in range(n+1)]
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                parent[x] = y
                return True
            return False
        for x, y in edges:
            if not union(x, y):
                return [x, y]