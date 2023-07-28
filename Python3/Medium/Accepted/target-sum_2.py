class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        if sum(nums) < target:
            return 0
        dp = [[0 for _ in range(2 * sum(nums) + 1)] for _ in range(len(nums))]
        dp[0][nums[0] + sum(nums)] += 1
        dp[0][-nums[0] + sum(nums)] += 1
        for i in range(1, len(nums)):
            for j in range(2 * sum(nums) + 1):
                if dp[i - 1][j] > 0:
                    dp[i][j + nums[i]] += dp[i - 1][j]
                    dp[i][j - nums[i]] += dp[i - 1][j]
        return dp[-1][target + sum(nums)]