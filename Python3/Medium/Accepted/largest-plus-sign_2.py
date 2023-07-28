class Solution:
    def orderOfLargestPlusSign(self, n: int, mines: List[List[int]]) -> int:
        
        grid = [[1 for _ in range(n)] for _ in range(n)]
        for x, y in mines:
            grid[x][y] = 0
        left = [[0 for _ in range(n)] for _ in range(n)]
        right = [[0 for _ in range(n)] for _ in range(n)]
        up = [[0 for _ in range(n)] for _ in range(n)]
        down = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    left[i][j] = 1 + left[i][j-1] if j > 0 else 1
                    up[i][j] = 1 + up[i-1][j] if i > 0 else 1
        for i in range(n-1, -1, -1):
            for j in range(n-1, -1, -1):
                if grid[i][j] == 1:
                    right[i][j] = 1 + right[i][j+1] if j < n-1 else 1
                    down[i][j] = 1 + down[i+1][j] if i < n-1 else 1
        ans = 0
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    ans = max(ans, min(left[i][j], right[i][j], up[i][j], down[i][j]))
        return ans