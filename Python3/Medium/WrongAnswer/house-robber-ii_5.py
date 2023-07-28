class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        if len(nums) == 3:
            return max(nums[0], nums[1], nums[0] + nums[2])
        return max(self.rob1(nums[1:]), self.rob1(nums[:-1]))