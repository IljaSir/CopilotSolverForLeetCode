class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        
        n = len(nums)
        if n == 0:
            return 0
        dp = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[i] - nums[j] <= k:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)