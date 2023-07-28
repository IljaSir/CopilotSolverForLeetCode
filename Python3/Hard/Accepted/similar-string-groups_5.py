class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def isSimilar(s1, s2) -> bool:
            count = 0
            for i in range(len(s1)):
                if s1[i] != s2[i]:
                    count += 1
                    if count > 2:
                        return False
            return True
        n = len(strs)
        uf = [i for i in range(n)]
        def find(x):
            if uf[x] != x:
                uf[x] = find(uf[x])
            return uf[x]
        def union(x, y):
            uf[find(x)] = find(y)
        for i in range(n):
            for j in range(i+1, n):
                if isSimilar(strs[i], strs[j]):
                    union(i, j)
        res = set()
        for i in range(n):
            res.add(find(i))
        return len(res)