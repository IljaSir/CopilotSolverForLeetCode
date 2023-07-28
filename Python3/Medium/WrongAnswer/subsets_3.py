class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [[], nums]
        if len(nums) == 2:
            return [[], [nums[0]], [nums[1]], nums]
        return [[], [nums[0]], [nums[1]], [nums[2]], [nums[0], nums[1]], [nums[0], nums[2]], [nums[1], nums[2]], nums]