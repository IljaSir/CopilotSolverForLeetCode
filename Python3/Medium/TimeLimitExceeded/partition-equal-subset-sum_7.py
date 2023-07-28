class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        if sum(nums) % 2 == 1:
            return False
        nums.sort()
        target = sum(nums) // 2
        def dfs(i, target):
            if target == 0:
                return True
            if i >= len(nums):
                return False
            if nums[i] > target:
                return False
            return dfs(i + 1, target - nums[i]) or dfs(i + 1, target)
        return dfs(0, target)