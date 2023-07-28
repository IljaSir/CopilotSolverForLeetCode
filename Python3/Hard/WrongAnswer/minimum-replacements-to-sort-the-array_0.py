class Solution:
    def minimumReplacement(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n <= 1:
            return 0
        dp = [0] * n
        for i in range(1, n):
            if nums[i] > nums[i - 1]:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(dp[i - 1] + 2, dp[i - 2] + 1)
        return dp[-1]