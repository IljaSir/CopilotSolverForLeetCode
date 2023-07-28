class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        
        def dfs(i, j, row, col):
            if i < 0 or j < 0 or i >= row or j >= col:
                return
            if land[i][j] == 0:
                return
            land[i][j] = 0
            dfs(i+1, j, row, col)
            dfs(i-1, j, row, col)
            dfs(i, j+1, row, col)
            dfs(i, j-1, row, col)
            return
        
        row, col = len(land), len(land[0])
        result = []
        for i in range(row):
            for j in range(col):
                if land[i][j] == 1:
                    dfs(i, j, row, col)
                    result.append([i, j, i, j])
                    for k in range(i, row):
                        if land[k][j] == 1:
                            result[-1][2] = k
                            land[k][j] = 0
                    for k in range(j, col):
                        if land[i][k] == 1:
                            result[-1][3] = k
                            land[i][k] = 0
        return result