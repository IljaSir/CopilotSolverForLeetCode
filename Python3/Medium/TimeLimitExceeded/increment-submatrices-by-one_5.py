class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        mat = [[0 for x in range(n)] for y in range(n)]
        for query in queries:
            row1, col1, row2, col2 = query
            for i in range(row1, row2+1):
                for j in range(col1, col2+1):
                    mat[i][j] += 1
        return mat