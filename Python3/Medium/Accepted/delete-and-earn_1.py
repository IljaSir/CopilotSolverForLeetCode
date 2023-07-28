class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        max_val = max(nums)
        dp = [0] * (max_val + 1)
        for num in nums:
            dp[num] += num
        for i in range(2, max_val + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + dp[i])
        return dp[max_val]