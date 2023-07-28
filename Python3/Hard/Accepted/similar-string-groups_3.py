class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        def find(x):
            if x != parent[x]:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            x, y = find(x), find(y)
            if x == y:
                return
            if rank[x] > rank[y]:
                x, y = y, x
            parent[x] = y
            if rank[x] == rank[y]:
                rank[y] += 1
        
        def similar(x, y):
            count = 0
            for i in range(len(x)):
                if x[i] != y[i]:
                    count += 1
                    if count > 2:
                        return False
            return True
        
        parent = list(range(len(strs)))
        rank = [0] * len(strs)
        for i in range(len(strs)):
            for j in range(i + 1, len(strs)):
                if similar(strs[i], strs[j]):
                    union(i, j)
        return sum(1 if i == parent[i] else 0 for i in range(len(parent)))