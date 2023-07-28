class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        
        pascal_triangle = []

        for i in range(numRows):
            row = [None for _ in range(i + 1)]
            row[0], row[-1] = 1, 1

            for j in range(1, len(row) - 1):
                row[j] = pascal_triangle[i - 1][j - 1] + pascal_triangle[i - 1][j]

            pascal_triangle.append(row)

        return pascal_triangle