class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        if k == 0:
            return 1
        if n == 1:
            return 1
        moves = [(-1, -2), (-1, 2), (1, -2), (1, 2), (-2, -1), (-2, 1), (2, -1), (2, 1)]
        dp = [[0 for _ in range(n)] for _ in range(n)]
        dp[row][column] = 1
        for _ in range(k):
            dp2 = [[0 for _ in range(n)] for _ in range(n)]
            for r in range(n):
                for c in range(n):
                    for dr, dc in moves:
                        if 0 <= r + dr < n and 0 <= c + dc < n:
                            dp2[r + dr][c + dc] += dp[r][c] / 8
            dp = dp2
        return sum(map(sum, dp))