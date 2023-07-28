class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)
        return max(self.rob1(nums[1:]), self.rob1(nums[:-1]))