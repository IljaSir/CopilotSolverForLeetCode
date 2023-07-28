class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        def dfs(row, column, k):
            if row < 0 or row >= n or column < 0 or column >= n:
                return 0
            if k == 0:
                return 1
            if (row, column, k) in cache:
                return cache[(row, column, k)]
            cache[(row, column, k)] = 0.125 * (dfs(row + 1, column + 2, k - 1) + dfs(row + 2, column + 1, k - 1) + dfs(row + 1, column - 2, k - 1) + dfs(row + 2, column - 1, k - 1) + dfs(row - 1, column + 2, k - 1) + dfs(row - 2, column + 1, k - 1) + dfs(row - 1, column - 2, k - 1) + dfs(row - 2, column - 1, k - 1))
            return cache[(row, column, k)]
        cache = {}
        return dfs(row, column, k)