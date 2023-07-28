class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        
        i = 0
        while i < len(nums):
            if i == len(nums) - 1:
                return nums[i]
            if nums[i] == nums[i+1]:
                i += 2
            else:
                return nums[i]