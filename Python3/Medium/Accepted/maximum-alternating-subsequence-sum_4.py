class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        # O(n) / O(1)
        # dp[i][0] = max(dp[i-1][0], dp[i-1][1] + nums[i])
        # dp[i][1] = max(dp[i-1][1], dp[i-1][0] - nums[i])
        # dp[0][0] = nums[0]
        # dp[0][1] = -nums[0]
        # return max(dp[-1][0], dp[-1][1])
        dp0 = dp1 = 0
        for num in nums:
            dp0, dp1 = max(dp0, dp1 + num), max(dp1, dp0 - num)
        return max(dp0, dp1)