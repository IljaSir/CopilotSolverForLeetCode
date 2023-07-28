class Solution:
    def canCross(self, stones: List[int]) -> bool:
        
        # DP
        # dp[i][j] means if we can reach to i-th stone with j-step
        # dp[i][j] = dp[k][j-1] or dp[k][j] or dp[k][j+1]
        # where k is the index of stone before i-th stone
        # Time O(n^2)
        # Space O(n^2)
        n = len(stones)
        dp = [[False] * n for _ in range(n)]
        dp[0][0] = True
        for i in range(1, n):
            for j in range(i-1, -1, -1):
                k = stones[i] - stones[j]
                if k > j + 1:
                    break
                dp[i][k] = dp[j][k-1] or dp[j][k] or dp[j][k+1]
                if i == n-1 and dp[i][k]:
                    return True
        return False