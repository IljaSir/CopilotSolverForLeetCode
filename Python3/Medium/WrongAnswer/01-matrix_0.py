class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        rows = len(mat)
        cols = len(mat[0])
        res = [[0 for _ in range(cols)] for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    res[i][j] = 0
                else:
                    if i == 0 and j == 0:
                        res[i][j] = 1 + min(res[i+1][j], res[i][j+1])
                    elif i == 0 and j == cols - 1:
                        res[i][j] = 1 + min(res[i+1][j], res[i][j-1])
                    elif i == rows - 1 and j == 0:
                        res[i][j] = 1 + min(res[i-1][j], res[i][j+1])
                    elif i == rows - 1 and j == cols - 1:
                        res[i][j] = 1 + min(res[i-1][j], res[i][j-1])
                    elif i == 0:
                        res[i][j] = 1 + min(res[i+1][j], res[i][j-1], res[i][j+1])
                    elif i == rows - 1:
                        res[i][j] = 1 + min(res[i-1][j], res[i][j-1], res[i][j+1])
                    elif j == 0:
                        res[i][j] = 1 + min(res[i-1][j], res[i+1][j], res[i][j+1])
                    elif j == cols - 1:
                        res[i][j] = 1 + min(res[i-1][j], res[i+1][j], res[i][j-1])
                    else:
                        res[i][j] = 1 + min(res[i-1][j], res[i+1][j], res[i][j-1], res[i][j+1])
        return res