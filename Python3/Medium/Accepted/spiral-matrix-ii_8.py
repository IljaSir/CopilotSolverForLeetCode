class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        if n == 1:
            return [[1]]
        res = [[0 for _ in range(n)] for _ in range(n)]
        num = 1
        for i in range(n//2):
            for j in range(i, n-1-i):
                res[i][j] = num
                num += 1
            for j in range(i, n-1-i):
                res[j][n-1-i] = num
                num += 1
            for j in range(n-1-i, i, -1):
                res[n-1-i][j] = num
                num += 1
            for j in range(n-1-i, i, -1):
                res[j][i] = num
                num += 1
        if n % 2 == 1:
            res[n//2][n//2] = num
        return res