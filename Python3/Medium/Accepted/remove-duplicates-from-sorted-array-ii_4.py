class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        if len(nums) <= 2:
            return len(nums)
        i = 0
        j = 1
        while i < len(nums) and j < len(nums):
            if nums[i] == nums[j]:
                if j - i < 2:
                    j += 1
                else:
                    nums.pop(j)
            else:
                i = j
                j += 1
        return len(nums)