class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        
        dp = [1 for _ in range(len(nums))]
        for i in range(len(nums)):
            for j in range(i):
                if nums[i] - nums[j] <= k:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)