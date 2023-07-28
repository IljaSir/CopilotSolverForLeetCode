class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        n = len(strs)
        if n < 2:
            return n
        parent = [i for i in range(n)]
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        def union(x, y):
            parent[find(x)] = find(y)
        def similar(a, b):
            diff = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    diff += 1
                    if diff > 2:
                        return False
            return True
        for i in range(n):
            for j in range(i+1, n):
                if similar(strs[i], strs[j]):
                    union(i, j)
        return len(set([find(x) for x in range(n)]))