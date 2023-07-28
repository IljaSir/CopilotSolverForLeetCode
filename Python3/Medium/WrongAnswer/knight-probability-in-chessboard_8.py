class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        if n == 1: return 1
        if k == 0: return 1
        if k == 1: return 0.125
        moves = [[-2, -1], [-2, 1], [2, -1], [2, 1], [-1, -2], [-1, 2], [1, -2], [1, 2]]
        dp = [[0] * n for _ in range(n)]
        dp[row][column] = 1
        for i in range(k):
            dp2 = [[0] * n for _ in range(n)]
            for r in range(n):
                for c in range(n):
                    for dr, dc in moves:
                        if 0 <= r + dr < n and 0 <= c + dc < n:
                            dp2[r + dr][c + dc] += dp[r][c] / 8
            dp = dp2
        return sum(map(sum, dp))