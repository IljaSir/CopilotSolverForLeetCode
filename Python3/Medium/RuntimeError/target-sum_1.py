class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        if sum(nums) < target or (sum(nums) + target) % 2 == 1:
            return 0
        p = (sum(nums) + target) // 2
        dp = [1] + [0] * p
        for num in nums:
            for i in range(p, num - 1, -1):
                dp[i] += dp[i - num]
        return dp[p]