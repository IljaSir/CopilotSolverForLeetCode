class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        parent = [i for i in range(len(edges)+1)]
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x,y):
            parent[find(x)] = find(y)
        for x,y in edges:
            if find(x) != find(y):
                union(x,y)
            else:
                return x,y