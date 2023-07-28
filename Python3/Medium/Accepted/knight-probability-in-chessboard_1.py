class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        def dfs(r, c, k):
            if r < 0 or r >= n or c < 0 or c >= n:
                return 0
            if k == 0:
                return 1
            if (r, c, k) in cache:
                return cache[(r, c, k)]
            cache[(r, c, k)] = sum(dfs(r + dr, c + dc, k - 1) for dr, dc in dirs) / 8
            return cache[(r, c, k)]
        
        cache = {}
        dirs = [(-1, -2), (-1, 2), (1, -2), (1, 2), (-2, -1), (-2, 1), (2, -1), (2, 1)]
        return dfs(row, column, k)