class Solution:
    def check(self, nums: List[int]) -> bool:
        
        if len(nums) == 1:
            return True
        if len(nums) == 2:
            return nums[0] <= nums[1]
        for i in range(len(nums)):
            if nums[i] > nums[(i+1) % len(nums)]:
                return False
        return True