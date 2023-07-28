class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        parent = {}
        rank = {}
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            xroot = find(x)
            yroot = find(y)
            if xroot == yroot:
                return False
            if rank[xroot] < rank[yroot]:
                parent[xroot] = yroot
            elif rank[xroot] > rank[yroot]:
                parent[yroot] = xroot
            else:
                parent[yroot] = xroot
                rank[xroot] += 1
            return True
        for edge in edges:
            if edge[0] not in parent:
                parent[edge[0]] = edge[0]
                rank[edge[0]] = 0
            if edge[1] not in parent:
                parent[edge[1]] = edge[1]
                rank[edge[1]] = 0
            if not union(edge[0], edge[1]):
                return edge