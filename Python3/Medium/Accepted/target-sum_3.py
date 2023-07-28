class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def findTargetSumWays(nums, target, i, memo):
            if (i, target) in memo:
                return memo[(i, target)]
            if i == len(nums):
                if target == 0:
                    return 1
                else:
                    return 0
            add = findTargetSumWays(nums, target - nums[i], i + 1, memo)
            subtract = findTargetSumWays(nums, target + nums[i], i + 1, memo)
            memo[(i, target)] = add + subtract
            return memo[(i, target)]
        return findTargetSumWays(nums, target, 0, {})