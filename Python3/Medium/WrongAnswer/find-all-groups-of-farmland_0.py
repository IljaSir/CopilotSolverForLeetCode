class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        
        m = len(land)
        n = len(land[0])
        def dfs(i, j):
            if i < 0 or i >= m or j < 0 or j >= n or land[i][j] != 1:
                return
            land[i][j] = -1
            dfs(i-1, j)
            dfs(i+1, j)
            dfs(i, j-1)
            dfs(i, j+1)
        res = []
        for i in range(m):
            for j in range(n):
                if land[i][j] == 1:
                    dfs(i, j)
                    res.append([i, j, i, j])
        for i in range(m):
            for j in range(n):
                if land[i][j] == -1:
                    for k in range(len(res)):
                        if res[k][0] <= i <= res[k][2] and res[k][1] <= j <= res[k][3]:
                            res[k][0] = min(res[k][0], i)
                            res[k][1] = min(res[k][1], j)
                            res[k][2] = max(res[k][2], i)
                            res[k][3] = max(res[k][3], j)
        return res