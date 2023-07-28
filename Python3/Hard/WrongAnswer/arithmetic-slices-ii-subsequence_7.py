class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        dp = [dict() for _ in range(len(nums))]
        for i in range(len(nums)):
            for j in range(i):
                diff = nums[i] - nums[j]
                dp[i][diff] = dp[i].get(diff, 0) + dp[j].get(diff, 0) + 1
        return sum([sum(dp[i].values()) for i in range(len(nums))])