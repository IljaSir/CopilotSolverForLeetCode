class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        
        # Time  complexity: O(n^2)
        # Space complexity: O(n^2)
        mat = [[0] * n for _ in range(n)]
        for row1i, col1i, row2i, col2i in queries:
            for row in range(row1i, row2i + 1):
                for col in range(col1i, col2i + 1):
                    mat[row][col] += 1
        return mat