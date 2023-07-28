class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        def check(t):
            visited = [[False]*n for _ in range(n)]
            def dfs(x, y):
                if x==n-1 and y==n-1:
                    return True
                visited[x][y] = True
                for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                    nx, ny = x+dx, y+dy
                    if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and grid[nx][ny]<=t:
                        if dfs(nx, ny):
                            return True
                return False
            return dfs(0, 0)
        l, r = grid[0][0], n**2-1
        while l<r:
            mid = (l+r)//2
            if check(mid):
                r = mid
            else:
                l = mid+1
        return l