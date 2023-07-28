class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        
        if grid[0][0] == 1:
            return -1
        if len(grid) == 1:
            return 1
        n = len(grid)
        grid[0][0] = 1
        q = [(0,0)]
        while q:
            x,y = q.pop(0)
            for dx, dy in ((1,0), (0,1), (-1,0), (0,-1), (1,1), (-1,-1), (1,-1), (-1,1)):
                nx, ny = x+dx, y+dy
                if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 0:
                    if nx == n-1 and ny == n-1:
                        return grid[x][y]+1
                    grid[nx][ny] = grid[x][y] + 1
                    q.append((nx,ny))
        return -1