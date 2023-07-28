class Solution:
    def matrixRankTransform(self, matrix: List[List[int]]) -> List[List[int]]:
        
        m, n = len(matrix), len(matrix[0])
        d = collections.defaultdict(list)
        for i in range(m):
            for j in range(n):
                d[matrix[i][j]].append([i, j])
        res = [[0] * n for _ in range(m)]
        rank = [0] * (m + n)
        for val in sorted(d):
            parent = list(range(m + n))
            rank2 = rank[:]
            for i, j in d[val]:
                i, j = find(i), find(j + m)
                parent[i] = j
                rank2[j] = max(rank2[i], rank2[j])
            for i, j in d[val]:
                res[i][j] = rank[find(i)] = rank[find(j + m)] = rank2[find(j + m)] + 1
        return res