class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        
        # 1. Brute Force
        # Time  complexity: O(N^2)
        # Space complexity: O(N^2)
        # N = 100
        # A = [[0] * k for k in range(1, N+1)]
        # A[0][0] = poured
        # for r in range(N):
        #     for c in range(r+1):
        #         q = (A[r][c] - 1.0) / 2.0
        #         if q > 0:
        #             A[r+1][c] += q
        #             A[r+1][c+1] += q
        # return min(1, A[query_row][query_glass])
        
        # 2. Dynamic Programming
        # Time  complexity: O(N^2)
        # Space complexity: O(N)
        # N = 100
        # dp = [0] * N
        # dp[0] = poured
        # for r in range(N):
        #     for c in range(r, -1, -1):
        #         q = (dp[c] - 1.0) / 2.0
        #         if q > 0:
        #             dp[c+1] += q
        #             dp[c] = q
        #         else:
        #             dp[c] = 0
        # return min(1, dp[query_glass])
        
        # 3. Dynamic Programming
        # Time  complexity: O(N^2)
        # Space complexity: O(1)
        N = 100
        dp = [0] * N
        dp[0] = poured
        for r in range(N):
            for c in range(r, -1, -1):
                dp[c+1] += dp[c] = max(0, (dp[c] - 1.0) / 2.0)
        return min(1, dp[query_glass])