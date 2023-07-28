class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        return max(self.robRange(nums, 0, len(nums)-2), self.robRange(nums, 1, len(nums)-1))