class Solution:
    def matrixScore(self, grid: List[List[int]]) -> int:
        
        R, C = len(grid), len(grid[0])
        ans = 0
        for c in range(C):
            col = 0
            for r in range(R):
                col += grid[r][c] ^ grid[r][0]
            ans += max(col, R - col) * 2 ** (C - 1 - c)
        return ans