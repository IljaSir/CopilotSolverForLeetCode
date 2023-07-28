class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def dfs(nums, target, index, sum):
            if index == len(nums):
                if sum == target:
                    return 1
                else:
                    return 0
            else:
                return dfs(nums, target, index+1, sum+nums[index]) + dfs(nums, target, index+1, sum-nums[index])
        return dfs(nums, target, 0, 0)