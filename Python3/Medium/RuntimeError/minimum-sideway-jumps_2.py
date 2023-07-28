class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        
        
        # the minimum number of side jumps to reach any lane at point n starting from lane 2 at point 0.
        # n = len(obstacles) - 1
        # dp = [[float('inf') for _ in range(4)] for _ in range(n+1)]
        # dp[0][2] = 0
        # for i in range(1, n+1):
        #     for j in range(1, 4):
        #         if obstacles[i] != j:
        #             dp[i][j] = min(dp[i][j], dp[i-1][j])
        #     for j in range(1, 4):
        #         if obstacles[i] != j:
        #             for k in range(1, 4):
        #                 if k != j and k != obstacles[i]:
        #                     dp[i][j] = min(dp[i][j], dp[i][k] + 1)
        # return min(dp[n])
        
        # the minimum number of side jumps to reach any lane at point n starting from lane 2 at point 0.
        n = len(obstacles) - 1
        dp = [[float('inf') for _ in range(4)] for _ in range(n+1)]
        dp[0][2] = 0
        for i in range(1, n+1):
            for j in range(1, 4):
                if obstacles[i] != j:
                    dp[i][j] = min(dp[i][j], dp[i-1][j])
            for j in range(1, 4):
                if obstacles[i] != j:
                    for k in range(1, 4):
                        if k != j and k != obstacles[i]:
                            dp[i][j] = min(dp[i][j], dp[i][k] + 1)
        return min(dp[n])
        
        # the minimum number of side jumps to reach any lane at point n starting from lane 2 at point 0.
        n = len(obstacles) - 1
        dp = [[float('inf') for _ in range(4)] for _ in range(n+1)]
        dp[0][2] = 0
        for i in range(1, n+1):
            for j in range(1, 4):
                if