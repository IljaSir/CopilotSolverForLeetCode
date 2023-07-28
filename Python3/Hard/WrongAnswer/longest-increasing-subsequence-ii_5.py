class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        
        # dp[i] = max(dp[j]) + 1, where j < i and nums[i] - nums[j] <= k
        dp = [1] * len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] - nums[j] <= k:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)