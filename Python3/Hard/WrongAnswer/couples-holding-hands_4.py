class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            parent[find(x)] = find(y)
        
        n = len(row)
        parent = list(range(n))
        for i in range(0, n, 2):
            union(row[i] // 2, row[i + 1] // 2)
        return n // 2 - len(set(find(x) for x in range(n)))