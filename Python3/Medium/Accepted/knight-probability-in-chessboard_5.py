class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        
        def getNeighbours(r, c):
            for dr, dc in [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < n and 0 <= nc < n:
                    yield nr, nc
        
        dp = [[0] * n for _ in range(n)]
        dp[row][column] = 1
        for _ in range(k):
            ndp = [[0] * n for _ in range(n)]
            for r in range(n):
                for c in range(n):
                    if dp[r][c] > 0:
                        for nr, nc in getNeighbours(r, c):
                            ndp[nr][nc] += dp[r][c] / 8
            dp = ndp
        
        return sum(map(sum, dp))