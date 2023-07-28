class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        
        if len(connections) < n - 1:
            return -1
        parents = [i for i in range(n)]
        def find(x):
            if parents[x] != x:
                parents[x] = find(parents[x])
            return parents[x]
        def union(x, y):
            parents[find(x)] = find(y)
        for x, y in connections:
            union(x, y)
        return len(set(find(i) for i in range(n))) - 1