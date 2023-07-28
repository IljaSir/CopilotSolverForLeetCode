class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        nums.sort()
        dp = [0] * (nums[-1] + 1)
        for i in range(len(nums)):
            dp[nums[i]] += nums[i]
        dp[1] = max(dp[0], dp[1])
        for i in range(2, len(dp)):
            dp[i] = max(dp[i - 1], dp[i - 2] + dp[i])
        return dp[-1]