class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        for k in range(min(m, n), 1, -1):
            for i in range(m - k + 1):
                for j in range(n - k + 1):
                    if self.isMagic(grid, i, j, k):
                        return k
        return 1