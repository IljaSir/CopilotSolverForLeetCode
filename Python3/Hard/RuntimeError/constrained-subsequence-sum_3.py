class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        
        # dp[i] = max(nums[i], dp[i-1]+nums[i], dp[i-2]+nums[i], ..., dp[i-k]+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i-2], dp[i-3], ..., dp[i-k])+nums[i])
        # dp[i] = max(nums[i], dp[i-1]+nums[i], max(dp[i