class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        nums.sort()
        dp = [0] * len(nums)
        dp[0] = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                dp[i] = dp[i-1] + nums[i]
            elif nums[i] == nums[i-1] + 1:
                dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            else:
                dp[i] = dp[i-1] + nums[i]
        return dp[-1]