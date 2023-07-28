class Solution:
    def findCrossingTime(self, n: int, k: int, time: List[List[int]]) -> int:
        
        
        def findCrossingTime(n: int, k: int, time: List[List[int]]) -> int:
            # Time  complexity: O(nk)
            # Space complexity: O(nk)
            # dp[i][j] = min time to move i boxes with last worker being j
            dp = [[float("inf")] * k for _ in range(n + 1)]
            for j in range(k):
                dp[0][j] = 0
            for i in range(1, n + 1):
                for j in range(k):
                    for l in range(k):
                        dp[i][j] = min(dp[i][j], dp[i - 1][l] + time[j][1] + time[l][3] + max(time[j][0], time[l][2]))
            return min(dp[-1])