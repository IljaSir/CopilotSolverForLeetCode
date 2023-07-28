class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] = 1 - grid[i][j]
        for i in range(n):
            cnt = 0
            for j in range(m):
                if grid[j][i] == 1:
                    cnt += 1
            if cnt < m - cnt:
                for j in range(m):
                    grid[j][i] = 1 - grid[j][i]
        ans = 0
        for i in range(m):
            temp = 0
            for j in range(n):
                temp = temp * 2 + grid[i][j]
            ans += temp
        return ans