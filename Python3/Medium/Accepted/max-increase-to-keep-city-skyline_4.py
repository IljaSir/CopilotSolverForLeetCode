class Solution:
    def maxIncreaseKeepingSkyline(self, grid: List[List[int]]) -> int:
        
        n = len(grid)
        left = [0] * n
        top = [0] * n
        for i in range(n):
            for j in range(n):
                left[i] = max(left[i], grid[i][j])
                top[j] = max(top[j], grid[i][j])
        ans = 0
        for i in range(n):
            for j in range(n):
                ans += min(left[i], top[j]) - grid[i][j]
        return ans