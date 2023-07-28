class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        for i in range(m):
            if grid[i][0] == 0:
                for j in range(n):
                    grid[i][j] ^= 1
        for j in range(1, n):
            cnt = 0
            for i in range(m):
                if grid[i][j] == 1:
                    cnt += 1
            if cnt < m - cnt:
                for i in range(m):
                    grid[i][j] ^= 1
        ans = 0
        for i in range(m):
            for j in range(n):
                ans += grid[i][j] * (1 << (n - j - 1))
        return ans