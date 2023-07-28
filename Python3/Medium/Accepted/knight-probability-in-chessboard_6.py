class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        def dfs(r, c, k):
            if k == 0:
                return 1
            if (r, c, k) in cache:
                return cache[(r, c, k)]
            total = 0
            for dr, dc in [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n:
                    total += dfs(nr, nc, k-1)
            cache[(r, c, k)] = total
            return total
        cache = {}
        return dfs(row, column, k) / 8**k