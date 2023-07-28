class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = dp[i-1] + 1 if nums[i] - nums[i-1] == nums[i-1] - nums[i-2] else 0
        # dp[i] = 1 if nums[i] - nums[i