class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        if k == 0:
            return 1
        if n == 1:
            return 1
        if k > n * n:
            return 1
        dp = [[0 for _ in range(n)] for _ in range(n)]
        dp[row][column] = 1
        for _ in range(k):
            dp2 = [[0 for _ in range(n)] for _ in range(n)]
            for i in range(n):
                for j in range(n):
                    for (di, dj) in [(1, 2), (2, 1), (-1, 2), (-2, 1), (1, -2), (2, -1), (-1, -2), (-2, -1)]:
                        if 0 <= i + di < n and 0 <= j + dj < n:
                            dp2[i + di][j + dj] += dp[i][j] / 8
            dp = dp2
        return sum(map(sum, dp))