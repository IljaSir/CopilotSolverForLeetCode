class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        if nums[0] != nums[1]:
            return nums[0]
        if nums[-1] != nums[-2]:
            return nums[-1]
        i = 1
        while i < len(nums):
            if nums[i] != nums[i-1] and nums[i] != nums[i+1]:
                return nums[i]
            i += 2