class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        
        return [[max(grid[i][j:j+3] + grid[i+1][j:j+3] + grid[i+2][j:j+3]) for j in range(len(grid)-2)] for i in range(len(grid)-2)]