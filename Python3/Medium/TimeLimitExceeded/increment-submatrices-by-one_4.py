class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        for query in queries:
            row1, col1, row2, col2 = query
            for row in range(row1, row2 + 1):
                for col in range(col1, col2 + 1):
                    matrix[row][col] += 1
        return matrix