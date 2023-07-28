class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        n = len(dist)
        dp = [[float('inf')]*(n+1) for _ in range(n)]
        for i in range(n):
            dp[i][0] = math.ceil(dist[i]/speed)
        for i in range(1, n):
            for j in range(1, i+1):
                dp[i][j] = min(dp[i-1][j-1], math.ceil((dp[i-1][j]+dist[i])/speed))
        for j in range(n):
            if dp[n-1][j] <= hoursBefore:
                return j
        return -1