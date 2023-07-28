class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        
        # Solution 1: DP
        # Time  complexity: O(n^2)
        # Space complexity: O(n^2)
        # n = len(stones)
        # dp = [[0] * n for _ in range(n)]
        # for i in range(n - 2, -1, -1):
        #     for j in range(i + 1, n):
        #         dp[i][j] = max(stones[i] - dp[i + 1][j], stones[j] - dp[i][j - 1])
        # return dp[0][n - 1]

        # Solution 2: DP
        # Time  complexity: O(n^2)
        # Space complexity: O(n)
        n = len(stones)
        dp = [0] * n
        for i in range(n - 2, -1, -1):
            pre = stones[i]
            for j in range(i + 1, n):
                pre, dp[j] = pre + stones[j], max(pre - dp[j], stones[j] + dp[j - 1] - pre)
        return dp[n - 1]