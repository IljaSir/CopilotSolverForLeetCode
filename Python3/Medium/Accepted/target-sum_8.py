class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        def dfs(nums, target, index, sum, memo):
            if index == len(nums):
                if sum == target:
                    return 1
                else:
                    return 0
            if (index, sum) in memo:
                return memo[(index, sum)]
            add = dfs(nums, target, index + 1, sum + nums[index], memo)
            minus = dfs(nums, target, index + 1, sum - nums[index], memo)
            memo[(index, sum)] = add + minus
            return memo[(index, sum)]
        return dfs(nums, target, 0, 0, {})