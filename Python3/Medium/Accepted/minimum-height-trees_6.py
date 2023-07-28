class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        
        if n == 1: return [0]
        d = collections.defaultdict(set)
        for a, b in edges:
            d[a].add(b)
            d[b].add(a)
        q = [i for i in range(n) if len(d[i]) == 1]
        while n > 2:
            n -= len(q)
            q2 = []
            for i in q:
                j = d[i].pop()
                d[j].remove(i)
                if len(d[j]) == 1: q2.append(j)
            q = q2
        return q