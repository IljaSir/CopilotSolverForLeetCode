class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        def walk(n, k, row, column):
            if row < 0 or row >= n or column < 0 or column >= n:
                return 0
            if k == 0:
                return 1
            if (row, column, k) in memo:
                return memo[(row, column, k)]
            memo[(row, column, k)] = sum([
                walk(n, k-1, row+dr, column+dc)
                for dr, dc in directions
            ]) / 8
            return memo[(row, column, k)]
        directions = [
            (1, 2),
            (1, -2),
            (-1, 2),
            (-1, -2),
            (2, 1),
            (2, -1),
            (-2, 1),
            (-2, -1),
        ]
        memo = {}
        return walk(n, k, row, column)