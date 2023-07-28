class Solution:
    def checkXMatrix(self, grid: List[List[int]]) -> bool:
        
        n = len(grid)
        if n == 3:
            return grid[0][0] and grid[0][2] and grid[1][1] and grid[2][0] and grid[2][2]
        if n == 4:
            return grid[0][0] and grid[0][3] and grid[1][1] and grid[1][2] and grid[2][1] and grid[2][2] and grid[3][0] and grid[3][3]
        for i in range(n):
            for j in range(n):
                if i == j or i + j == n - 1:
                    if grid[i][j] == 0:
                        return False
                else:
                    if grid[i][j] != 0:
                        return False
        return True