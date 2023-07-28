class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        
        n = len(grid)
        ans = []
        for i in range(n - 2):
            ans.append([])
            for j in range(n - 2):
                ans[i].append(max(grid[i][j:j+3] + grid[i+1][j:j+3] + grid[i+2][j:j+3]))
        return ans