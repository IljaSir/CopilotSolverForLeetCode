class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        # Find the first decreasing number from right to left
        # Find the first number greater than the decreasing number from right to left
        # Swap the two numbers
        # Reverse the remaining numbers
        # Time complexity: O(n)
        # Space complexity: O(1)
        # Find the first decreasing number from right to left
        i = len(nums) - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        # Find the first number greater than the decreasing number from right to left
        j = len(nums) - 1
        while j >= 0 and nums[j] <= nums[i]:
            j -= 1
        # Swap the two numbers
        nums[i], nums[j] = nums[j], nums[i]
        # Reverse the remaining numbers
        nums[i + 1:] = nums[:i:-1]