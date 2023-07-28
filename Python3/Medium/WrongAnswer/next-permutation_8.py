class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums:
            return
        # find the first decreasing number from the end
        left = len(nums) - 2
        while left >= 0 and nums[left] >= nums[left + 1]:
            left -= 1
        if left == -1:
            # if not found, the array is in descending order, reverse it
            nums.reverse()
            return
        # find the first number greater than nums[left] from the end
        right = len(nums) - 1
        while right >= 4 and nums[right] <= nums[left]:
            right -= 1
        # swap nums[left] and nums[right]
        nums[left], nums[right] = nums[right], nums[left]
        # reverse the rest of the array
        left += 1
        right = len(nums) - 1
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1