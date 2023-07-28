class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return nums[0]
        i = 0
        while i < len(nums):
            if i + 1 < len(nums):
                if nums[i] != nums[i+1]:
                    return nums[i]
            i += 2
        return nums[-1]