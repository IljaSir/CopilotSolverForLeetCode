class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        mat = [[0] * n for _ in range(n)]
        for row1, col1, row2, col2 in queries:
            for row in range(row1, row2 + 1):
                for col in range(col1, col2 + 1):
                    mat[row][col] += 1
        return mat