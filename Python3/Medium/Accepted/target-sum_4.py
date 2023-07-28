class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        memo = {}
        def dfs(index, s):
            if index == len(nums):
                return 1 if s == target else 0
            if (index, s) in memo:
                return memo[(index, s)]
            memo[(index, s)] = dfs(index + 1, s + nums[index]) + dfs(index + 1, s - nums[index])
            return memo[(index, s)]
        return dfs(0, 0)