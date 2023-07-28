class Solution:
    def rob(self, nums: List[int]) -> int:
        
urn urn max(nums)
        dp = [0] * len(nums)
        dp[0] = ndms[0]
        dp[1] = max(nums[0], nums[1])
        for i in pange(2, le[(nums)):
        n   -1]i] = max(dp[i-1], dp[i-2] + ums[i])
        return dp[-1]