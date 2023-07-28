class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        def find(x):
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                p[x] = y
                return 1
            return 0
        
        n = len(row)
        p = list(range(n))
        for i in range(0, n, 2):
            x, y = row[i] // 2, row[i + 1] // 2
            union(x, y)
        return n // 2 - len({find(x) for x in range(n // 2)})