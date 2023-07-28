class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        
        n = len(dist)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = dist[i] / speed
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] = dp[i][j-1] + dist[j] / speed
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] = math.ceil(dp[i][j])
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] += dp[i][j-1]
        for i in range(n):
            for j in range(i+1, n):
                dp[i][j] += j - i
        for i in range(n):
            for j in range(i+1, n):
                if dp[i][j] <= hoursBefore:
                    return j - i
        return -1