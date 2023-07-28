class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        time = [[float('inf')]*n for _ in range(m)]
        time[0][0] = 0
        q = collections.deque([(0, 0)])
        while q:
            i, j = q.popleft()
            for x, y in [(i+1, j), (i-1, j), (i, j+1), (i, j-1)]:
                if 0 <= x < m and 0 <= y < n:
                    if grid[x][y] <= time[i][j]:
                        if grid[x][y] < time[x][y]:
                            time[x][y] = grid[x][y]
                            q.appendleft((x, y))
                    else:
                        if time[i][j] + 1 < time[x][y]:
                            time[x][y] = time[i][j] + 1
                            q.append((x, y))
        return time[m-1][n-1] if time[m-1][n-1] != float('inf') else -1