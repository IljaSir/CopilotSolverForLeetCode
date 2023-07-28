class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        row = [max(grid[i]) for i in range(n)]
        col = [max([grid[i][j] for i in range(n)]) for j in range(n)]
        return sum(min(row[i], col[j]) - grid[i][j] for i in range(n) for j in range(n))