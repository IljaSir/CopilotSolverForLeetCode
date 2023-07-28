class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        
        def find(x):
            if x != p[x]:
                p[x] = find(p[x])
            return p[x]
        def union(x, y):
            px, py = find(x), find(y)
            if px != py:
                p[px] = py
        n = len(row)
        p = list(range(n))
        for i in range(0, n, 2):
            union(row[i] // 2, row[i + 1] // 2)
        return len(set(find(i) for i in range(n))) - 1