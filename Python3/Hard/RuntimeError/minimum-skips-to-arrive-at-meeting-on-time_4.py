class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        n = len(dist)
        dp = [float('inf')] * (n+1)
        dp[0] = 0
        for i in range(n):
            for j in range(n, -1, -1):
                dp[j] = math.ceil(dp[j] / speed) * speed + dist[i]
                if j > 0: dp[j] = min(dp[j], dp[j-1] + dist[i])
        for i in range(n+1):
            if dp[i] <= hoursBefore * speed: return i
        return -1