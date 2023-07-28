class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        
        m, n = len(land), len(land[0])
        def dfs(i, j):
            if land[i][j] == 0:
                return
            land[i][j] = 0
            nonlocal r1, r2, c1, c2
            r1, r2, c1, c2 = min(r1, i), max(r2, i), min(c1, j), max(c2, j)
            if i > 0:
                dfs(i-1, j)
            if i < m-1:
                dfs(i+1, j)
            if j > 0:
                dfs(i, j-1)
            if j < n-1:
                dfs(i, j+1)
        res = []
        for i in range(m):
            for j in range(n):
                if land[i][j] == 1:
                    r1, r2, c1, c2 = i, i, j, j
                    dfs(i, j)
                    res.append([r1, c1, r2, c2])
        return res