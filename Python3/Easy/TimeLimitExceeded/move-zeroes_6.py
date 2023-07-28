class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if len(nums) == 0:
            return
        if len(nums) == 1:
            if nums[0] == 0:
                return
            else:
                return
        i = 0
        while i < len(nums):
            if nums[i] == 0:
                nums.pop(i)
                nums.append(0)
                i = i - 1
            i = i + 1
        return