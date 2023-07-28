class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        dp = [float('inf') for _ in range(len(dist)+1)]
        dp[0] = 0
        for i in range(len(dist)):
            for j in range(len(dist), 0, -1):
                dp[j] = min(dp[j], dp[j-1]+(dist[i]+speed-1)//speed)
                dp[j] += (dist[i]+speed-1)//speed
        for i in range(len(dist)+1):
            if dp[i] <= hoursBefore * speed:
                return i
        return -1