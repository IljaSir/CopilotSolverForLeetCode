class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if len(nums) <= 2:
            return len(nums)
        i = 1
        j = 1
        count = 1
        while j < len(nums):
            if nums[j] == nums[i-1]:
                count += 1
            else:
                count = 1
            if count <= 2:
                nums[i] = nums[j]
                i += 1
            j += 1
        return i