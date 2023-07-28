class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        def rotate(matrix, k):
            m, n = len(matrix), len(matrix[0])
            for i in range(min(m, n) // 2):
                # print(matrix)
                # print(i)
                # print(matrix[i][i:n-i])
                # print(matrix[i][i:n-i][k % (n - 2 * i):])
                # print(matrix[i][i:n-i][:k % (n - 2 * i)])
                matrix[i][i:n-i] = matrix[i][i:n-i][k % (n - 2 * i):] + matrix[i][i:n-i][:k % (n - 2 * i)]
                # print(matrix[i][i:n-i])
                # print(matrix[i+1:m-i-1])
                for j in range(i+1, m-i-1):
                    matrix[j][i], matrix[j][n-i-1] = matrix[j][n-i-1], matrix[j][i]
                # print(matrix[i+1:m-i-1])
                # print(matrix[m-i-1][i:n-i])
                # print(matrix[m-i-1][i:n-i][k % (n - 2 * i):])
                # print(matrix[m-i-1][i:n-i][:k % (n - 2 * i)])
                matrix[m-i-1][i:n-i] = matrix[m-i-1][i:n-i][k % (n - 2 * i):] + matrix[m-i-1][i:n-i][:k % (n - 2 * i)]
                # print(matrix[m-i-1][i:n-i])
            return matrix
        return rotate(grid, k)