class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        dp = [[float('inf')]*n for _ in range(m)]
        dp[0][0] = 0
        q = collections.deque([(0,0)])
        while q:
            i, j = q.popleft()
            for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                if 0<=x<m and 0<=y<n:
                    if grid[x][y] <= grid[i][j]:
                        t = grid[i][j] + 1
                    else:
                        t = grid[x][y] + 1
                    if t < dp[x][y]:
                        dp[x][y] = t
                        q.append((x,y))
        return dp[-1][-1]