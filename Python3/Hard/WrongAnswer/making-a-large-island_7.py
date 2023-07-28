class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        
        N, M = len(grid), len(grid[0])
        def dfs(i, j, count):
            if 0 <= i < N and 0 <= j < M and grid[i][j] == 1:
                grid[i][j] = count
                return 1 + dfs(i+1, j, count) + dfs(i-1, j, count) + dfs(i, j+1, count) + dfs(i, j-1, count)
            return 0

        count = 2
        area = collections.defaultdict(int)
        for i in range(N):
            for j in range(M):
                if grid[i][j] == 1:
                    area[count] = dfs(i, j, count)
                    count += 1
        ans = max(area.values() or [0])
        for i in range(N):
            for j in range(M):
                if grid[i][j] == 0:
                    ans = max(ans, 1 + sum(area[grid[x][y]] for x, y in ((i+1, j), (i-1, j), (i, j+1), (i, j-1)) if 0 <= x < N and 0 <= y < M and grid[x][y] > 1))
        return ans