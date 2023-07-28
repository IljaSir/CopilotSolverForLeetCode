class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        n = len(dist)
        dp = [[float("inf")] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = 0
        for i in range(n):
            for j in range(n + 1):
                if dp[i][j] < float("inf"):
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + (dist[i] + speed - 1) // speed)
                    if j < n:
                        dp[i + 1][j + 1] = min(dp[i + 1][j + 1], (dp[i][j] + dist[i] + speed - 1) // speed)
        for j in range(n + 1):
            if dp[n][j] <= hoursBefore:
                return j
        return -1