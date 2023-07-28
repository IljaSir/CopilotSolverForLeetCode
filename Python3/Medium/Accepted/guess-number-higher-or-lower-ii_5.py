class Solution:
    def getMoneyAmount(self, n: int) -> int:
        
        # dp[i][j] = the min money to guarantee a win for subproblem [i, j].
        # Note: subproblems are inclusive.
        # dp[i][j] = min(k + max(dp[i][k-1], dp[k+1][j])) where i <= k <= j
        dp = [[0]*(n+1) for _ in range(n+1)]
        for lo in range(n, 0, -1):
            for hi in range(lo+1, n+1):
                dp[lo][hi] = min(k + max(dp[lo][k-1], dp[k+1][hi])
                                 for k in range(lo, hi))
        return dp[1][n]