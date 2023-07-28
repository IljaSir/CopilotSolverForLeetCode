class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            parent[find(x)] = find(y)
        n = len(row)
        parent = [i for i in range(n)]
        for i in range(0, n, 2):
            union(row[i], row[i + 1])
        res = 0
        for i in range(0, n, 2):
            if find(i) != find(i + 1):
                res += 1
                union(i, i + 1)
        return res