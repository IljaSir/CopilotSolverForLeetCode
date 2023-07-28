class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        

        # Solution 1: one pass
        # left, right = 0, len(nums) - 1
        # i = 0
        # while i <= right:
        #     if nums[i] == 0:
        #         nums[left], nums[i] = nums[i], nums[left]
        #         left += 1
        #         i += 1
        #     elif nums[i] == 2:
        #         nums[right], nums[i] = nums[i], nums[right]
        #         right -= 1
        #     else:
        #         i += 1

        # Solution 2: two pass
        count0 = 0
        count1 = 0
        for n in nums:
            if n == 0:
                count0 += 1
            elif n == 1:
                count1 += 1
        nums[:count0] = [0] * count0
        nums[count0:count0+count1] = [1] * count1
        nums[count0+count1:] = [2] * (len(nums) - count0 - count1)