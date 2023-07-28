class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        def dfs(row, col):
            if row < 0 or row == len(grid) or col < 0 or col == len(grid[0]) or grid[row][col] != 1:
                return 0
            grid[row][col] = -1
            return 1 + dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col + 1) + dfs(row, col - 1)
        return max(dfs(row, col) for row in range(len(grid)) for col in range(len(grid[0])))