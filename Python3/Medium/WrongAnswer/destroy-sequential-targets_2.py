class Solution:
    def destroyTargets(self, nums: List[int], space: int) -> int:
        
        nums.sort()
        res = 0
        for i in range(len(nums)):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            res = max(res, 1 + (len(nums) - i - 1) // space)
        return res