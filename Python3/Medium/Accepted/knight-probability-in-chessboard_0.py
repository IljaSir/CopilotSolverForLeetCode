class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        dirs = [(1, 2), (2, 1), (-1, 2), (2, -1), (1, -2), (-2, 1), (-1, -2), (-2, -1)]
        dp = [[0] * n for _ in range(n)]
        dp[row][column] = 1
        for _ in range(k):
            dp2 = [[0] * n for _ in range(n)]
            for r, row in enumerate(dp):
                for c, val in enumerate(row):
                    for dr, dc in dirs:
                        if 0 <= r + dr < n and 0 <= c + dc < n:
                            dp2[r + dr][c + dc] += val / 8.0
            dp = dp2
        return sum(map(sum, dp))