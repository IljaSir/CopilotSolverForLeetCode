class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def similar(a, b):
            if len(a) != len(b):
                return False
            if a == b:
                return True
            cnt = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    cnt += 1
                    if cnt > 2:
                        return False
            return True
        
        def find(x):
            if x != parents[x]:
                parents[x] = find(parents[x])
            return parents[x]
        
        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                parents[x] = y
                size[y] += size[x]
        
        n = len(strs)
        parents = list(range(n))
        size = [1] * n
        for i in range(n):
            for j in range(i + 1, n):
                if similar(strs[i], strs[j]):
                    union(i, j)
        return len({find(i) for i in range(n)})