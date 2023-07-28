class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        # DP
        # dp[i][j] = True if we can reach stone i with last jump size j
        # dp[i][j] = True if dp[k][j-1] or dp[k][j] or dp[k][j+1] is True
        # where k is the index of the last stone before stone i
        # O(n^2)
        n = len(stones)
        dp = [[False] * n for _ in range(n)]
        dp[0][0] = True
        for i in range(1, n):
            for j in range(i):
                k = stones[i] - stones[j]
                if k > j + 1:
                    break
                dp[i][k] = dp[j][k-1] or dp[j][k] or dp[j][k+1]
        return any(dp[-1])