class Solution:
    def minSkips(self, dist: List[int], speed: int, hoursBefore: int) -> int:
        
        def check(t):
            # the time to finish the i-th road
            # with j skips
            dp = [[float('inf')]*(t+1) for _ in range(len(dist))]
            dp[0][0] = math.ceil(dist[0]/speed)
            for i in range(1, len(dist)):
                for j in range(t+1):
                    dp[i][j] = dp[i-1][j] + math.ceil(dist[i]/speed)
                    if j > 0:
                        dp[i][j] = min(dp[i][j], math.ceil((dp[i-1][j-1] - 1)*speed/dist[i-1])*speed/dist[i-1] + math.ceil(dist[i]/speed))
            return min(dp[-1]) <= hoursBefore
        # binary search
        l, r = 0, 10**7
        while l < r:
            mid = (l+r)//2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l if check(l) else -1