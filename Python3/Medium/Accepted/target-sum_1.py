class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        memo = {}
        def helper(i, t):
            if i == len(nums):
                return 1 if t == 0 else 0
            if (i, t) in memo:
                return memo[(i, t)]
            memo[(i, t)] = helper(i + 1, t - nums[i]) + helper(i + 1, t + nums[i])
            return memo[(i, t)]
        return helper(0, target)