class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        if grid[0][0] != 0 or grid[n-1][n-1] != 0:
            return -1
        if n == 1:
            return 1
        q = []
        q.append([0,0])
        grid[0][0] = 1
        while q:
            x, y = q.pop(0)
            if x == n-1 and y == n-1:
                return grid[x][y]
            for i in range(-1, 2):
                for j in range(-1, 2):
                    if i == 0 and j == 0:
                        continue
                    if x + i < 0 or x + i >= n or y + j < 0 or y + j >= n:
                        continue
                    if grid[x + i][y + j] == 0:
                        grid[x + i][y + j] = grid[x][y] + 1
                        q.append([x + i, y + j])
        return -1