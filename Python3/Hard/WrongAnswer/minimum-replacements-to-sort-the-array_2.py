class Solution:
    def minimumReplacement(self, nums: List[int]) -> int:
        
        # dp[i] = minimum replacements to make nums[:i] sorted
        # dp[i] = dp[i-1] + 1 if nums[i] <= nums[i-1]
        # dp[i] = min(dp[i-1], dp[i-2]+1) if nums[i] > nums[i-1]
        # dp[0] = 0
        # dp[1] = 1
        dp = [0] * len(nums)
        dp[0] = 0
        dp[1] = 1
        for i in range(2, len(nums)):
            if nums[i] <= nums[i-1]:
                dp[i] = dp[i-1] + 1
            else:
                dp[i] = min(dp[i-1], dp[i-2]+1)
        return dp[-1]