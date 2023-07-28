class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        matrix = [[0] * n for _ in range(n)]
        num = 1
        for i in range((n + 1) // 2):
            for j in range(i, n - i):
                matrix[i][j] = num
                num += 1
            for j in range(i + 1, n - i):
                matrix[j][n - i - 1] = num
                num += 1
            for j in range(n - i - 2, i - 1, -1):
                matrix[n - i - 1][j] = num
                num += 1
            for j in range(n - i - 2, i, -1):
                matrix[j][i] = num
                num += 1
        return matrix