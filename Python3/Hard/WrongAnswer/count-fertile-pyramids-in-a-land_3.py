class Solution:
    def countPyramids(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        def isPyramid(r, c, h):
            for i in range(r, r+h):
                for j in range(c-h+1, c+h):
                    if not (r <= i <= r + h - 1 and c - (i - r) <= j <= c + (i - r)) or grid[i][j] == 0:
                        return False
            return True
        def isInversePyramid(r, c, h):
            for i in range(r-h+1, r+1):
                for j in range(c-h+1, c+h):
                    if not (r - h + 1 <= i <= r and c - (r - i) <= j <= c + (r - i)) or grid[i][j] == 0:
                        return False
            return True
        ans = 0
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 1:
                    h = 1
                    while r+h < m and c-h >= 0 and c+h < n and grid[r+h][c] == 1 and grid[r+h][c-h] == 1 and grid[r+h][c+h] == 1:
                        if isPyramid(r, c, h):
                            ans += 1
                        h += 1
                    h = 1
                    while r-h >= 0 and c-h >= 0 and c+h < n and grid[r-h][c] == 1 and grid[r-h][c-h] == 1 and grid[r-h][c+h] == 1:
                        if isInversePyramid(r, c, h):
                            ans += 1
                        h += 1
        return ans