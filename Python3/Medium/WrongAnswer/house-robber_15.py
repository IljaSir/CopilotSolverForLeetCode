class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) < 2:
            return sum(nums)
        dp = [0, nums[0]]
        for i in range(1, len(nums)):
            dp.append(max(dp[i-1], dp[i] + nums[i]))
        return dp[-1]