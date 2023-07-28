class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        
        n = len(nums)
        if n == 1:
            return nums
        if n == 2:
            nums[0], nums[1] = nums[1], nums[0]
            return nums
        
        # find the first decreasing element
        i = n - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        if i < 0:
            nums.sort()
            return nums
        
        # find the first element larger than nums[i]
        j = n - 1
        while j >= 0 and nums[j] <= nums[i]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]
        nums[i + 1:] = nums[i + 1:][::-1]
        return nums