class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        mat = [[0 for _ in range(n)] for _ in range(n)]
        for query in queries:
            for i in range(query[0], query[2] + 1):
                for j in range(query[1], query[3] + 1):
                    mat[i][j] += 1
        return mat