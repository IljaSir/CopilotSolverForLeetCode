class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # find the first decreasing number from the end
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -= 1
        
        # find the smallest number that is larger than nums[i]
        j = len(nums) - 1
        while j >= 0 and nums[j] <= nums[i]:
            j -= 1
        
        # swap two numbers
        if i >= 0:
            nums[i], nums[j] = nums[j], nums[i]
        
        # reverse the rest of the array
        nums[i+1:] = nums[i+1:][::-1]