class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        
        self.ans = 0
        def dfs(nums, target, pos, sum):
            if pos == len(nums):
                if sum == target:
                    self.ans += 1
            else:
                dfs(nums, target, pos+1, sum+nums[pos])
                dfs(nums, target, pos+1, sum-nums[pos])
        dfs(nums, target, 0, 0)
        return self.ans