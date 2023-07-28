class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        def find(x):
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                p[y] = x
        n = len(row)
        p = [i for i in range(n)]
        for i in range(0, n, 2):
            union(row[i] // 2, row[i + 1] // 2)
        return n // 2 - len(set(find(x) for x in range(n)))