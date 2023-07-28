class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        for i in range(len(grid)):
            if grid[i][0] == 0:
                for j in range(len(grid[i])):
                    grid[i][j] = 1 - grid[i][j]
        for i in range(1, len(grid[0])):
            c = 0
            for j in range(len(grid)):
                if grid[j][i] == 1:
                    c += 1
            if c < len(grid) / 2:
                for j in range(len(grid)):
                    grid[j][i] = 1 - grid[j][i]
        res = 0
        for i in grid:
            res += int(''.join([str(j) for j in i]), 2)
        return res