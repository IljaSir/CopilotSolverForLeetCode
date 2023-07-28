class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        
        n = len(nums) // 3
        nums.sort()
        dp = [[float('inf')] * (n + 1) for _ in range(n + 1)]
        dp[0][0] = 0
        for i in range(1, n + 1):
            for j in range(n + 1):
                dp[i][j] = min(dp[i][j], dp[i - 1][j] + nums[3 * i - j - 1] - nums[3 * i - j - 2])
                dp[i][j] = min(dp[i][j], dp[i][j - 1] + nums[3 * i - j - 1] - nums[3 * i - j - 3])
        return dp[n][n]