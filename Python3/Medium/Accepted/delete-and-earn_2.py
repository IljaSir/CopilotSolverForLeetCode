class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [0] * (max(nums) + 1)
        for num in nums:
            dp[num] += num
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i-2] + dp[i])
        return dp[-1]