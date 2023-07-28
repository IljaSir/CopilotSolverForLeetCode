class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x,y):
            parent[find(x)] = find(y)
        parent = [i for i in range(len(edges)+1)]
        for x,y in edges:
            if find(x) == find(y):
                return [x,y]
            else:
                union(x,y)