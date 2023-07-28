class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        for i in range(len(grid)):
            if grid[i][0] == 0:
                for j in range(len(grid[i])):
                    grid[i][j] = 1 - grid[i][j]
        for j in range(len(grid[0])):
            s = 0
            for i in range(len(grid)):
                s += grid[i][j]
            if s < len(grid) / 2:
                for i in range(len(grid)):
                    grid[i][j] = 1 - grid[i][j]
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                res += grid[i][j] * 2 ** (len(grid[i]) - j - 1)
        return res