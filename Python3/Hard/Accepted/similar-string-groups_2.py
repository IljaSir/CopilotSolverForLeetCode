class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]
        
        def union(x, y):
            x = find(x)
            y = find(y)
            if x != y:
                p[x] = y
        
        def isSimilar(x, y):
            count = 0
            for i in range(len(x)):
                if x[i] != y[i]:
                    count += 1
                    if count > 2:
                        return False
            return True
        
        p = [i for i in range(len(strs))]
        for i in range(len(strs)):
            for j in range(i+1, len(strs)):
                if isSimilar(strs[i], strs[j]):
                    union(i, j)
        return len(set([find(i) for i in range(len(strs))]))