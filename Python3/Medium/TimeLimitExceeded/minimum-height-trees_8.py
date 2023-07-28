class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        
        if n == 1:
            return [0]
        edges = collections.defaultdict(list)
        for a, b in edges:
            edges[a].append(b)
            edges[b].append(a)
        leaves = [i for i in range(n) if len(edges[i]) == 1]
        while n > 2:
            n -= len(leaves)
            new_leaves = []
            for i in leaves:
                j = edges[i].pop()
                edges[j].remove(i)
                if len(edges[j]) == 1:
                    new_leaves.append(j)
            leaves = new_leaves
        return leaves