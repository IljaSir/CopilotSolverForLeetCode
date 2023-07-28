class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        result = [[0 for _ in range(n)] for _ in range(n)]
        num = 1
        for i in range(n // 2):
            for j in range(i, n - i - 1):
                result[i][j] = num
                num += 1
            for j in range(i, n - i - 1):
                result[j][n - i - 1] = num
                num += 1
            for j in range(n - i - 1, i, -1):
                result[n - i - 1][j] = num
                num += 1
            for j in range(n - i - 1, i, -1):
                result[j][i] = num
                num += 1
        if n % 2 == 1:
            result[n // 2][n // 2] = num
        return result