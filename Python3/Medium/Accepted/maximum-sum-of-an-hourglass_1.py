class Solution:
    def maxSum(self, grid: List[List[int]]) -> int:
        
        m = len(grid)
        n = len(grid[0])
        max_sum = -float("inf")
        for i in range(m - 2):
            for j in range(n - 2):
                max_sum = max(max_sum, sum(grid[i][j:j + 3]) + grid[i + 1][j + 1] + sum(grid[i + 2][j:j + 3]))
        return max_sum