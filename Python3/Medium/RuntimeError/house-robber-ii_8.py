class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        return max(self.rob_line(nums[1:]), self.rob_line(nums[:-1]))