class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j] or (i - 1 >= 0 and nums[i] != nums[i - 1]):
                i += 1
                nums[i] = nums[j]
        return i + 1